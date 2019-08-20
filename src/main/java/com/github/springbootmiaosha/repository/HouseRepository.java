package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.House;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 房屋相关接口
 *
 * @author lizhangyu
 * @date 2019-08-16
 */
public interface HouseRepository extends PagingAndSortingRepository<House, Long>, JpaSpecificationExecutor<House> {

    /**
     * 更新封面
     * @param id
     * @param cover
     */
    @Modifying
    @Query("update House as house set house.cover = :cover where house.id = :id")
    void updateCover(@Param(value = "id") Long id, @Param(value = "cover") String cover);
}

