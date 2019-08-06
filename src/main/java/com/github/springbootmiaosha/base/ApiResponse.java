package com.github.springbootmiaosha.base;

/**
 * Api格式封装
 *
 * @author lizhangyu
 * @Date 2019-08-06
 */
public class ApiResponse {

    private int code;
    private String message;
    private Object data;
    private boolean more;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

}
