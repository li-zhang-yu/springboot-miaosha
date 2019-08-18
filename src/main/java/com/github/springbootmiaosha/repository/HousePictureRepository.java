package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.HousePicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 房屋图片相关接口
 *
 * @author lizhangyu
 * @date 2019-08-17
 */
public interface HousePictureRepository extends JpaRepository<HousePicture, Long> {

    /**
     * 根据房屋id查找所有的房屋图片
     * @param houseId
     * @return
     */
    List<HousePicture> findAllByHouseId(Long houseId);
}
