package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户相关接口
 *
 * @author lizhangyu
 * @Date 2019-08-08
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * 根据名字查找用户
     * @param userName
     * @return
     */
    User findByName(String userName);

}
