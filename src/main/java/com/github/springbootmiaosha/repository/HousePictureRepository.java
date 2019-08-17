package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.HousePicture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 房屋图片相关接口
 *
 * @author lizhangyu
 * @date 2019-08-17
 */
public interface HousePictureRepository extends JpaRepository<HousePicture, Long> {
}
