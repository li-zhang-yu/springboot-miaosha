package com.github.springbootmiaosha.repository;

import com.github.springbootmiaosha.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 角色相关接口
 *
 * @author lizhangyu
 * @Date 2019-08-09
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    /**
     * 根据用户id查找角色列表
     * @param userId
     * @return
     */
    List<Role> findRolesByUserId(Long userId);
}
