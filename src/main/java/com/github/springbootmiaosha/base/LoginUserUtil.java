package com.github.springbootmiaosha.base;

import com.github.springbootmiaosha.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 用户登陆工具类
 *
 * @author lizhangyu
 * @date 2019-08-17
 */
public class LoginUserUtil {

    /**
     * 懒加载
     * @return
     */
    public static User load(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != null && principal instanceof User){
            return (User) principal;
        }

        return null;
    }

    /**
     * 获取登陆用户id
     * @return
     */
    public static Long getLoginUserId(){
        User user = load();
        if(user == null){
            return -1L;
        }
        return user.getId();
    }

}
