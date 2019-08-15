package com.github.springbootmiaosha.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 房屋实体类
 *
 * @author lizhangyu
 * @date 2019-08-15
 */
public class House {

    /**
     * house唯一标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    /**
     * 价格
     */
    private int price;

    /**
     * 面积
     */
    private int area;

    /**
     * 卧室数量
     */
    private int room;

    /**
     * 楼层
     */
    private int floor;

    /**
     * 总楼层
     */
    @Column(name = "total_floor")
    private int totalFloor;

    /**
     * 被看次数
     */
    @Column(name = "watch_times")
    private int watchTimes;

    /**
     * 建立年限
     */
    @Column(name = "build_year")
    private int buildYear;

    /**
     * 房屋状态
     */
    private int status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最近数据更新时间
     */
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    /**
     * 城市标记缩写
     */
    @Column(name = "city_en_name")
    private String cityEnName;

    /**
     * 地区英文简写
     */
    @Column(name = "region_en_name")
    private String regionEnName;

    /**
     * 封面
     */
    private String cover;

    /**
     * 房屋朝向
     */
    private int direction;

    /**
     * 距地铁距离
     */
    @Column(name = "distance_to_subway")
    private int distanceToSubway;

    /**
     * 客厅数量
     */
    private int parlour;

    /**
     * 所在小区
     */
    private String district;

    /**
     * 所属管理员id
     */
    @Column(name = "admin_id")
    private Long adminId;

    /**
     * 卧室数量
     */
    private int bathroom;

    /**
     * 街道
     */
    private String street;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }

    public int getWatchTimes() {
        return watchTimes;
    }

    public void setWatchTimes(int watchTimes) {
        this.watchTimes = watchTimes;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCityEnName() {
        return cityEnName;
    }

    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }

    public String getRegionEnName() {
        return regionEnName;
    }

    public void setRegionEnName(String regionEnName) {
        this.regionEnName = regionEnName;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDistanceToSubway() {
        return distanceToSubway;
    }

    public void setDistanceToSubway(int distanceToSubway) {
        this.distanceToSubway = distanceToSubway;
    }

    public int getParlour() {
        return parlour;
    }

    public void setParlour(int parlour) {
        this.parlour = parlour;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
