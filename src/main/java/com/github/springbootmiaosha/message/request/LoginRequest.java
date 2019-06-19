package com.github.springbootmiaosha.message.request;

/**
 * 登陆请求信息
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
public class LoginRequest extends Request {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
