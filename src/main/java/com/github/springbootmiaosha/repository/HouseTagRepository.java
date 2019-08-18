package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.HouseTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 房屋标签相关接口
 *
 * @author lizhangyu
 * @date 2019-08-15
 */
public interface HouseTagRepository extends JpaRepository<HouseTag, Long> {

    /**
     * 通过名称和房屋id查找标签
     * @param name
     * @param houseId
     * @return
     */
    HouseTag findByNameAndHouseId(String name, Long houseId);

    /**
     * 通过房屋id查找房屋标签
     * @param houseId
     * @return
     */
    List<HouseTag> findAllByHouseId(Long houseId);
}
