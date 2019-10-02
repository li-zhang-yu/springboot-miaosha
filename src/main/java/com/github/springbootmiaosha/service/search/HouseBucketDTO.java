package com.github.springbootmiaosha.service.search;

/**
 * 房屋bucketDTO实体类
 *
 * @author lizhangyu
 * @date 2019-10-01
 */
public class HouseBucketDTO {

    /**
     * 聚合bucket的key
     */
    private String key;

    /**
     * 聚合结果值
     */
    private long count;

    public HouseBucketDTO(String key, long count) {
        this.key = key;
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

//    @Override
//    public String toString() {
//        return "HouseBucketDTO{" +
//                "key='" + key + '\'' +
//                ", count=" + count +
//                '}';
//    }
}
