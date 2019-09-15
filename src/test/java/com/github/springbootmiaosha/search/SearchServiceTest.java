package com.github.springbootmiaosha.search;

import com.github.springbootmiaosha.SpringbootMiaoshaApplicationTests;
import com.github.springbootmiaosha.service.ServiceMultiResult;
import com.github.springbootmiaosha.service.search.ISearchService;
import com.github.springbootmiaosha.web.form.RentSearch;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 索引测试类
 *
 * @author lizhangyu
 * @date 2019-09-04
 */
public class SearchServiceTest extends SpringbootMiaoshaApplicationTests {

    @Autowired
    private ISearchService searchService;

    @Test
    public void testIndex() {
        Long targetHouseId = 15L;
        searchService.index(targetHouseId);
    }

    @Test
    public void testRemove() {
        Long targetHouseId = 15L;
        searchService.remove(targetHouseId);
    }

    @Test
    public void testQuery() {
        RentSearch rentSearch = new RentSearch();
        rentSearch.setCityEnName("bj");
        rentSearch.setStart(0);
        rentSearch.setSize(10);
        ServiceMultiResult<Long> serviceResult = searchService.query(rentSearch);
//        System.out.println(serviceResult.getTotal());
        Assert.assertEquals(4, serviceResult.getTotal());
    }
}
