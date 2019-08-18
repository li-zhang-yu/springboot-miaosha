package com.github.springbootmiaosha.entity;

import javax.persistence.*;

/**
 * 房屋标签实体类
 *
 * @author lizhangyu
 * @date 2019-08-15
 */
@Entity
@Table(name = "house_tag")
public class HouseTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标签id
     */
    @Column(name = "house_id")
    private Long houseId;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 默认构造器
     */
    public HouseTag() {
    }

    public HouseTag(Long houseId, String name) {
        this.houseId = houseId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
