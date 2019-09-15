package com.github.springbootmiaosha.service.search;

import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.web.form.RentSearch;

/**
 * 检索接口
 *
 * @author lizhangyu
 * @date 2019-09-03
 */
public interface ISearchService {

    /**
     * 索引目标房源
     * @param houseId
     */
    void index(Long houseId);

    /**
     * 移除房源索引
     * @param houseId
     */
    void remove(Long houseId);

    /**
     * 查询房源接口
     * @param rentSearch
     * @return
     */
    ServiceMultiResult<Long> query(RentSearch rentSearch);
}
