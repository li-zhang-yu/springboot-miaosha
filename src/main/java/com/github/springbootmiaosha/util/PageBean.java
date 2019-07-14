package com.github.springbootmiaosha.util;

import java.util.List;

/***
 * 分页工具类
 *
 * @author lizhangyu
 * @Date 2019-07-14
 */
public class PageBean<T> {

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 总数量
     */
    private Integer totalCount;

    /**
     * 数据列表
     */
    private List<T> dataList;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

}
