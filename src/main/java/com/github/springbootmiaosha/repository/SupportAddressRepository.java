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

    /**
     * 通过英文简写和行政级别获取城市区域
     * @param enName
     * @param level
     * @return
     */
    SupportAddress findByEnNameAndLevel(String enName, String level);

    /**
     * 通过英文简写和上一级行政单位名获取区/县区域
     * @param enName
     * @param belongTo
     * @return
     */
    SupportAddress findByEnNameAndBelongTo(String enName, String belongTo);
}
