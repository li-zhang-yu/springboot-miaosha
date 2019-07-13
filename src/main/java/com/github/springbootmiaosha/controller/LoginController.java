package com.github.springbootmiaosha.controller;

import com.github.springbootmiaosha.message.request.LoginRequest;
import com.github.springbootmiaosha.message.response.LoginResponse;
import com.github.springbootmiaosha.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/login")
    public LoginResponse login(LoginRequest request){
        LoginResponse  response= loginService.login(request);
        return response;
    }

}
