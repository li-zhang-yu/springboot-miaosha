package com.github.springbootmiaosha.service.search;

/**
 * 房屋关键字推荐自动补全实体类
 *
 * @author lizhangyu
 * @date 2019-09-22
 */
public class HouseSuggest {

    private String input;

    /**
     * 默认权重
     */
    private int weight = 10;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
