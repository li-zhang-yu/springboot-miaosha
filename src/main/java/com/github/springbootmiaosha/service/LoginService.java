package com.github.springbootmiaosha.service;

import com.github.springbootmiaosha.message.request.LoginRequest;
import com.github.springbootmiaosha.message.response.LoginResponse;

/**
 * 登陆接口定义类
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
public interface LoginService {

    LoginResponse login(LoginRequest request);

}
