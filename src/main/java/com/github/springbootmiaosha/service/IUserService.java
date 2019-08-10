package com.github.springbootmiaosha.service;

import com.github.springbootmiaosha.entity.User;

/**
 * 用户相关接口
 *
 * @author lizhangyu
 * @Date 2019-08-09
 */
public interface IUserService {

    User findUserByName(String userName);


}
