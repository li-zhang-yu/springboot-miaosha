package com.github.springbootmiaosha.web.dto;

/**
 * 七牛云上传返回结果信息实体类
 *
 * @author lizhangyu
 * @date 2019-08-13
 */
public final class QiNiuPutRet {

    public String key;
    public String hash;
    public String bucket;
    public int width;
    public int height;

    @Override
    public String toString() {
        return "QiNiuPutRet{" +
                "key='" + key + '\'' +
                ", hash='" + hash + '\'' +
                ", bucket='" + bucket + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

}
