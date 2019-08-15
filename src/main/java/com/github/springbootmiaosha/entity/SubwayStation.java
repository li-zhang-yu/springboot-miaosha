package com.github.springbootmiaosha.entity;

import javax.persistence.*;

/**
 * 地铁站实体类
 *
 * @author lizhangyu
 * @date 2019-08-15
 */
@Entity
@Table(name = "subway_station")
public class SubwayStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 所属地铁线id
     */
    @Column(name = "subway_id")
    private Long subwayId;

    /**
     * 站点名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubwayId() {
        return subwayId;
    }

    public void setSubwayId(Long subwayId) {
        this.subwayId = subwayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
