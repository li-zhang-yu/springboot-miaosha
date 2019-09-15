package com.github.springbootmiaosha.service.search;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springbootmiaosha.entity.House;
import com.github.springbootmiaosha.entity.HouseDetail;
import com.github.springbootmiaosha.entity.HouseTag;
import com.github.springbootmiaosha.repository.HouseDetailRepository;
import com.github.springbootmiaosha.repository.HouseRepository;
import com.github.springbootmiaosha.repository.HouseTagRepository;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.index.reindex.DeleteByQueryRequestBuilder;
import org.elasticsearch.rest.RestStatus;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * 搜索接口实现类
 *
 * @author lizhangyu
 * @date 2019-09-03
 */
@Service
public class SearchServiceImpl implements ISearchService {

    private static final Logger logger = LoggerFactory.getLogger(ISearchService.class);

    /**
     * 索引名称
     */
    private static final String INDEX_NAME = "xunwu";

    /**
     * 索引类型
     */
    private static final String INDEX_TYPE = "house";

    /**
     * 索引主题
     */
    private static final String INDEX_TOPIC = "house_build";

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private HouseDetailRepository houseDetailRepository;

    @Autowired
    private HouseTagRepository houseTagRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TransportClient esClient;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = INDEX_TOPIC)
    private void handleMessage(String content) {
        try {
            HouseIndexMessage message = objectMapper.readValue(content, HouseIndexMessage.class);

            switch (message.getOperation()) {
                case HouseIndexMessage.INDEX:
                    this.createOrUpdateIndex(message);
                    break;
                case HouseIndexMessage.REMOVE:
                    this.removeIndex(message);
                    break;
                default:
                    logger.warn("Not support message content " + content);
                    break;
            }
        }catch (IOException e) {
            logger.error("Cannot parse json for " + content, e);
        }

    }

    /**
     * 创建或者更新索引
     * @param message
     */
    private void createOrUpdateIndex(HouseIndexMessage message) {
        Long houseId = message.getHouseId();
        Optional<House> houseExample = houseRepository.findById(houseId);

        if (!houseExample.isPresent()) {
            logger.error("Index house {} does not exist!", houseId);
            this.index(houseId, message.getRetry() + 1);
            return;
        }

        House house = houseExample.get();

        HouseIndexTemplate indexTemplate = new HouseIndexTemplate();
        modelMapper.map(house, indexTemplate);

        HouseDetail detail = houseDetailRepository.findByHouseId(houseId);

        if (detail == null) {
            //异常情况
        }

        List<HouseTag> tags = houseTagRepository.findAllByHouseId(houseId);
        if (tags != null && !tags.isEmpty()) {
            List<String> tagStrings = new ArrayList<>();
            tags.forEach(houseTag -> {
                tagStrings.add(houseTag.getName());
            });
            indexTemplate.setTags(tagStrings);
        }

        SearchRequestBuilder requestBuilder = this.esClient.prepareSearch(INDEX_NAME)
                .setTypes(INDEX_TYPE)
                .setQuery(QueryBuilders.termQuery(HouseIndexKey.HOUSE_ID, houseId));

        logger.debug(requestBuilder.toString());
        SearchResponse searchResponse = requestBuilder.get();

        boolean success = false;
        long totalHit = searchResponse.getHits().getTotalHits();
        if (totalHit == 0) {
            create(indexTemplate);
        }else if (totalHit == 1) {
            String esId = searchResponse.getHits().getAt(0).getId();
            success = update(esId, indexTemplate);
        }else {
            success = deleteAndCreate(totalHit, indexTemplate);
        }

        if (success) {
            logger.debug("Index success with house " + houseId);
        }

    }

    @Override
    public void index(Long houseId) {
        this.index(houseId, 0);
    }

    private void index(Long houseId, int retry) {

        if (retry > HouseIndexMessage.MAX_ENTRY) {
            logger.error(" Retry index times over 3 for house:" + houseId + " please check it!");
            return;
        }

        HouseIndexMessage message = new HouseIndexMessage(houseId, HouseIndexMessage.INDEX, retry);

        try {
            kafkaTemplate.send(INDEX_TOPIC, objectMapper.writeValueAsString(message));
        }catch (JsonProcessingException e) {
            logger.error("Json encode error for " + message);
        }

    }


    @Override
    public void remove(Long houseId) {
        this.remove(houseId, 0);
    }

    /**
     * 删除索引
     * @param houseId
     * @param retry
     */
    private void remove(Long houseId, int retry) {
        if (retry > HouseIndexMessage.MAX_ENTRY) {
            logger.error(" Retry remove times over 3 for house:" + houseId + " please check it!");
            return;
        }

        HouseIndexMessage message = new HouseIndexMessage(houseId, HouseIndexMessage.REMOVE, retry);

        try {
            kafkaTemplate.send(INDEX_TOPIC, objectMapper.writeValueAsString(message));
        }catch (JsonProcessingException e) {
            logger.error("Json encode error for " + message);
        }

    }

    /**
     * 删除索引
     * @param message
     */
    private void removeIndex(HouseIndexMessage message) {
        Long houseId = message.getHouseId();
        DeleteByQueryRequestBuilder builder = DeleteByQueryAction.INSTANCE
                .newRequestBuilder(esClient)
                .filter(QueryBuilders.termQuery(HouseIndexKey.HOUSE_ID, houseId))
                .source(INDEX_NAME);

        logger.debug("Delete by query for house: " + builder);

        BulkByScrollResponse response = builder.get();
        long deleted = response.getDeleted();
        logger.debug("Delete total " + deleted);

        if (deleted <= 0) {
            this.remove(houseId, message.getRetry() + 1);
        }

    }

    /**
     * 创建索引
     * @param indexTemplate
     * @return
     */
    private boolean create(HouseIndexTemplate indexTemplate) {

        try {
            IndexResponse response = this.esClient.prepareIndex(INDEX_NAME, INDEX_TYPE)
                    .setSource(objectMapper.writeValueAsBytes(indexTemplate), XContentType.JSON).get();
            logger.debug("Create index with house: " + indexTemplate.getHouseId());

            if (response.status() == RestStatus.CREATED) {
                return true;
            }else {
                return false;
            }
        }catch (JsonProcessingException e){
            logger.error("Error to index house " + indexTemplate.getHouseId(), e);
            return false;
        }

    }

    /**
     * 更新索引
     * @param esId
     * @param indexTemplate
     * @return
     */
    private boolean update(String esId, HouseIndexTemplate indexTemplate) {

        try {
            UpdateResponse response = this.esClient.prepareUpdate(INDEX_NAME, INDEX_TYPE, esId)
                    .setDoc(objectMapper.writeValueAsBytes(indexTemplate), XContentType.JSON).get();
            logger.debug("Update index with house: " + indexTemplate.getHouseId());

            if (response.status() == RestStatus.OK) {
                return true;
            }else {
                return false;
            }
        }catch (JsonProcessingException e){
            logger.error("Error to update house " + indexTemplate.getHouseId(), e);
            return false;
        }
    }

    /**
     * 删除并创建索引
     * @param totalHit
     * @param indexTemplate
     * @return
     */
    private boolean deleteAndCreate(long totalHit, HouseIndexTemplate indexTemplate) {
        DeleteByQueryRequestBuilder builder = DeleteByQueryAction.INSTANCE
                .newRequestBuilder(esClient)
                .filter(QueryBuilders.termQuery(HouseIndexKey.HOUSE_ID, indexTemplate.getHouseId()))
                .source(INDEX_NAME);

        logger.debug("Delete by query for house: " + builder);

        BulkByScrollResponse response = builder.get();
        long deleted = response.getDeleted();

        if (deleted != totalHit) {
            logger.warn("Need delete {}, but{} was deleted!", totalHit, deleted);
            return false;
        }else {
            return create(indexTemplate);
        }
    }

}
