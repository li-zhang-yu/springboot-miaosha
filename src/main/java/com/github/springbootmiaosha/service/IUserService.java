package com.github.springbootmiaosha.service;

import com.github.springbootmiaosha.entity.User;
import com.github.springbootmiaosha.web.dto.UserDTO;

/**
 * 用户相关接口
 *
 * @author lizhangyu
 * @Date 2019-08-09
 */
public interface IUserService {

    /**
     * 通过名字查找用户
     * @param userName
     * @return
     */
    User findUserByName(String userName);

    /**
     * 通过id查找用户
     * @param userid
     * @return
     */
    ServiceResult<UserDTO> findById(Long userid);


}
