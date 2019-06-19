package com.github.springbootmiaosha.dao;

import com.github.springbootmiaosha.entity.User;

/**
 * 用户相关接口
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}