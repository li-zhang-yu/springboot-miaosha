package com.github.springbootmiaosha.service.impl;

import com.github.springbootmiaosha.dao.UserMapper;
import com.github.springbootmiaosha.entity.User;
import com.github.springbootmiaosha.message.request.LoginRequest;
import com.github.springbootmiaosha.message.response.LoginResponse;
import com.github.springbootmiaosha.service.LoginService;
import com.github.springbootmiaosha.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 登陆接口实现类
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登陆
     * @param request
     * @return
     */
    @Override
    public LoginResponse login(LoginRequest request) {

        String username = request.getUsername();
        String password = request.getPassword();
        LoginResponse response = new LoginResponse();

        User user = userMapper.selectByUserNameAndPassword(username,password);

        //当用户不存在的时候自动注册
        if (user == null) {
            User newUser = new User();
            newUser.setName(username);
            newUser.setPassword(password);
            newUser.setAddTime(DateUtil.formatTime(new Date()));
            userMapper.insertByUsernameAndPassword(newUser);
        }
        response.setCode(0);
        response.setMsg("success");
        return response;
    }

    /**
     * 根据用户的ip获取用户的地址
     * @param request
     * @return
     */
    public String getGuessPosition(HttpServletRequest request){
        return null;
    }
}
