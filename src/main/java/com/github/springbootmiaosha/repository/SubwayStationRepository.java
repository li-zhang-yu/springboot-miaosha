package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.SubwayStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 地铁站相关接口
 *
 * @author lizhangyu
 * @date 2019-08-15
 */
public interface SubwayStationRepository extends JpaRepository<SubwayStation, Long> {

    /**
     * 查找对应地铁线路的所有站点
     * @param subwayId
     * @return
     */
    List<SubwayStation> findAllBySubwayId(Long subwayId);
}
