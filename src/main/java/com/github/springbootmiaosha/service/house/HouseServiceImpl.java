package com.github.springbootmiaosha.service.house;

import com.github.springbootmiaosha.entity.House;
import com.github.springbootmiaosha.entity.HouseTag;
import com.github.springbootmiaosha.repository.HouseRepository;
import com.github.springbootmiaosha.repository.HouseTagRepository;
import com.github.springbootmiaosha.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 房屋接口业务层
 *
 * @author lizhangyu
 * @date 2019-08-16
 */
@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private HouseTagRepository houseTagRepository;

    @Override
    @Transactional
    public ServiceResult addTag(Long houseId, String tag) {
        House house = houseRepository.getOne(houseId);

        if (house == null) {
            return ServiceResult.notFound();
        }

        HouseTag houseTag = houseTagRepository.findByNameAndHouseId(tag, houseId);

        if (houseTag != null) {
            return new ServiceResult(false, "标签已存在");
        }

        houseTagRepository.save(new HouseTag(houseId, tag));

        return ServiceResult.success();
    }
}
