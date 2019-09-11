package com.github.springbootmiaosha.search;

import com.github.springbootmiaosha.SpringbootMiaoshaApplicationTests;
import com.github.springbootmiaosha.service.search.ISearchService;
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
        boolean success = searchService.index(targetHouseId);
        Assert.assertTrue(success);
    }
}
