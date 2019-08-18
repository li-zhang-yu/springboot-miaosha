package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.HouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 房屋详情相关接口
 *
 * @author lizhangyu
 * @date 2019-08-17
 */
public interface HouseDetailRepository extends JpaRepository<HouseDetail, Long> {
}