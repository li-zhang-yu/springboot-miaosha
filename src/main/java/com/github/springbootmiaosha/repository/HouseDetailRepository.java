package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.HouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 房屋详情相关接口
 *
 * @author lizhangyu
 * @date 2019-08-17
 */
public interface HouseDetailRepository extends JpaRepository<HouseDetail, Long> {

    /**
     * 根据房屋id查找房屋详情
     * @param houseId
     * @return
     */
    HouseDetail findByHouseId(Long houseId);

    /**
     * 通过房屋ids查找房屋列表详情
     * @param houseIds
     * @return
     */
    List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);
}
