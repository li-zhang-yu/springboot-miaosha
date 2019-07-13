package com.github.springbootmiaosha.test;

import com.github.springbootmiaosha.util.DateUtil;

import java.util.Date;

/**
 * 测试时间工具类
 *
 * @author lizhangyu
 * @Date 2019-07-13
 */
public class testDate {

    public static void main(String[] args) {
        System.out.println(DateUtil.getTodayDate());
        System.out.println(DateUtil.formatDate(new Date()));
        System.out.println(DateUtil.formatTime(new Date()));
    }
}
