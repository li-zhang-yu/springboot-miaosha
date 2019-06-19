package com.github.springbootmiaosha.message.response;

/**
 * 基础响应类
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
public class Response {

    /**
     * 响应码
     */
    public int code;

    /**
     * 响应信息
     */
    public String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
