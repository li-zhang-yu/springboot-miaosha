package com.github.springbootmiaosha.web.dto;

/**
 * 地铁返回结果实体类
 *
 * @author lizhangyu
 * @date 2019-08-14
 */
public class SubWayDto {

    private Long id;
    private String name;
    private String cityEnName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityEnName() {
        return cityEnName;
    }

    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }

}
