package com.github.springbootmiaosha.controller;

import com.github.springbootmiaosha.entity.User;
import com.github.springbootmiaosha.message.request.LoginRequest;
import com.github.springbootmiaosha.message.response.LoginResponse;
import com.github.springbootmiaosha.service.LoginService;
import com.github.springbootmiaosha.util.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登陆控制层
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    /**
     * 测试
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        return "hello";
    }

    /**
     * 登陆接口
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public LoginResponse login(LoginRequest request){
        LoginResponse  response= loginService.login(request);
        return response;
    }

    /**
     * 获取用户列表
     * @return
     */
    @RequestMapping("/userList")
    public PageBean<User> getUserList(){
        PageBean<User> pageBean = loginService.getUserList();
        return pageBean;
    }

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    @RequestMapping("/getUser")
    public User getUserByid(Integer id){
        User user = loginService.getUserById(id);
        return user;
    }

}
