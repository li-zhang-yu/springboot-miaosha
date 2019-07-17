package com.github.springbootmiaosha.dao;

import com.github.springbootmiaosha.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户相关接口
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名和密码获取用户信息
     * @param username
     * @param password
     * @return
     */
    User selectByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int insertByUsernameAndPassword(User user);

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUserList();

}