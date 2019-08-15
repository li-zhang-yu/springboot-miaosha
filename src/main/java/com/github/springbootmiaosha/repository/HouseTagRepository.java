package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.HouseTag;
import org.springframework.data.repository.CrudRepository;

/**
 * 房屋标签相关接口
 *
 * @author lizhangyu
 * @date 2019-08-15
 */
public interface HouseTagRepository extends CrudRepository<HouseTag, Long> {
}
