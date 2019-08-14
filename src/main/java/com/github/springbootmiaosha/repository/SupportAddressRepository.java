package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 地址支持相关接口
 *
 * @author lizhangyu
 * @date 2019-08-13
 */
public interface SupportAddressRepository extends CrudRepository<SupportAddress, Long> {

    /**
     * 获取所有行政级别的信息
     * @param level
     * @return
     */
    List<SupportAddress> findAllByLevel(String level);

    /**
     * 获取市下的所有区和县
     * @param level
     * @param belong
     * @return
     */
    List<SupportAddress> findAllByLevelAndBelongTo(String level, String belong);

}
