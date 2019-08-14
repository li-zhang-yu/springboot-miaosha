package com.github.springbootmiaosha.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 服务地址返回结果实体类
 *
 * @author lizhangyu
 * @date 2019-08-14
 */
public class SupportAddressDto {

    private long id;

    @JsonProperty(value = "belong_to")
    private String belong_to;

    @JsonProperty(value = "en_name")
    private String enName;

    @JsonProperty(value = "cn_name")
    private String cnName;

    private String level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBelong_to() {
        return belong_to;
    }

    public void setBelong_to(String belong_to) {
        this.belong_to = belong_to;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
