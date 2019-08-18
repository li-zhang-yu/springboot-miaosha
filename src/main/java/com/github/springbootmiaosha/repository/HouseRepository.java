package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.House;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 房屋相关接口
 *
 * @author lizhangyu
 * @date 2019-08-16
 */
public interface HouseRepository extends PagingAndSortingRepository<House, Long>, JpaSpecificationExecutor<House> {
}

