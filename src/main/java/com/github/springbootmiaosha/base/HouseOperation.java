package com.github.springbootmiaosha.base;

/**
 * 房屋操作状态常量定义
 *
 * @author lizhangyu
 * @date 2019-08-21
 */
public class HouseOperation {

    /**
     * 通过审核
     */
    public static final int PASS = 1;

    /**
     * 下架，重新审核
     */
    public static final int PULL_OUT = 2;

    /**
     * 逻辑删除
     */
    public static final int DELETE = 3;

    /**
     * 出租
     */
    public static final int RENT = 4;
}
