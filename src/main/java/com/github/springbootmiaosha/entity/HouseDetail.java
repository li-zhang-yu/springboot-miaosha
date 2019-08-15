package com.github.springbootmiaosha.entity;

import javax.persistence.*;

/**
 * 房屋详情实体类
 *
 * @author lizhangyu
 * @date 2019-08-15
 */
@Entity
@Table(name = "house_detail")
public class HouseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 详细描述
     */
    private String description;

}
