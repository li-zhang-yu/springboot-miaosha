package com.github.springbootmiaosha.entity;

import javax.persistence.*;

/**
 * 房屋图片实体类
 *
 * @author lizhangyu
 * @date 2019-08-15
 */
@Entity
@Table(name = "house_picture")
public class HousePicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 所属房屋id
     */
    @Column(name = "house_id")
    private Long houseId;

    /**
     * 图片路径
     */
    @Column(name = "cdn_prefix")
    private String cdnPrefix;

    /**
     * 宽
     */
    private int width;

    /**
     * 高
     */
    private int height;

    /**
     * 所属房屋位置
     */
    private String location;

    /**
     * 文件名
     */
    private String path;

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

    public String getCdnPrefix() {
        return cdnPrefix;
    }

    public void setCdnPrefix(String cdnPrefix) {
        this.cdnPrefix = cdnPrefix;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
