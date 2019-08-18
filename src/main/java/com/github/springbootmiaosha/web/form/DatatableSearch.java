package com.github.springbootmiaosha.web.form;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 表格搜索实体类
 *
 * @author lizhangyu
 * @date 2019-08-17
 */
public class DatatableSearch {

    /**
     * Datatables要求回显字段
     */
    private int draw;

    /**
     * Datatables规定分页字段
     */
    private int start;
    private int length;

    /**
     * 房源状态
     */
    private Integer status;

    /**
     * 起始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeMin;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTimeMax;

    /**
     * 城市
     */
    private String city;

    /**
     * 标题
     */
    private String title;

    /**
     * 朝向
     */
    private String direction;

    /**
     * 排序
     */
    private String orderBy;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTimeMin() {
        return createTimeMin;
    }

    public void setCreateTimeMin(Date createTimeMin) {
        this.createTimeMin = createTimeMin;
    }

    public Date getCreateTimeMax() {
        return createTimeMax;
    }

    public void setCreateTimeMax(Date createTimeMax) {
        this.createTimeMax = createTimeMax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
