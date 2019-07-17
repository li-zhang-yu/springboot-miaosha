package com.github.springbootmiaosha.service;

import com.github.springbootmiaosha.entity.User;
import com.github.springbootmiaosha.message.request.LoginRequest;
import com.github.springbootmiaosha.message.response.LoginResponse;
import com.github.springbootmiaosha.util.PageBean;


/**
 * 登陆接口定义类
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
public interface LoginService {

    /**
     * 登陆接口
     * @param request
     * @return
     */
    LoginResponse login(LoginRequest request);

    /**
     * 获取用户列表
     * @return
     */
    PageBean<User> getUserList();

    /**
     * 通过主键查找用户
     * @param id
     * @return
     */
    User getUserById(Integer id);

}
