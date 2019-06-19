package com.github.springbootmiaosha.message.response;

import java.util.List;

/**
 * 返回数据响应类
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
public class ResponseData extends Response {

    public List<?> dataList;

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }
}
