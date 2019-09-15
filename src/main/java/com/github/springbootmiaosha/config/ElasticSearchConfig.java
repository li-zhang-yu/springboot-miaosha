package com.github.springbootmiaosha.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ES配置文件
 *
 * @author lizhangyu
 * @date 2019-09-01
 */
@Configuration
public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String esHost;

    @Value("${elasticsearch.port}")
    private int esPort;

    @Value("${elasticsearch.cluster.name}")
    private String esName;

    @Bean
    public TransportClient client() throws UnknownHostException {

//         指定集群名,默认为elasticsearch,如果改了集群名,这里一定要加
        Settings settings = Settings.builder()
                .put("cluster.name", this.esName)
//                .put("client.transport.sniff", true)
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);

        /*
        这里只配置了一个节点的地址然添加进去,也可以配置多个从节点添加进去再返回
         */
        TransportAddress master = new TransportAddress(
                    InetAddress.getByName(esHost),
                    esPort
        );
//        InetSocketTransportAddress master = new InetSocketTransportAddress(
//                InetAddress.getByName(esHost), esPort
//        );

        client.addTransportAddress(master);

        return client;
    }


}
