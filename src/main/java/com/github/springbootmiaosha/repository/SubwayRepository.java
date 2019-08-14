package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.Subway;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 地铁相关接口
 *
 * @author lizhangyu
 * @date 2019-08-14
 */
public interface SubwayRepository extends CrudRepository<Subway, Long> {

    /**
     * 查询所属城市的所有地铁
     * @param cityEnName
     * @return
     */
    List<Subway> findAllByCityEnName(String cityEnName);

}
