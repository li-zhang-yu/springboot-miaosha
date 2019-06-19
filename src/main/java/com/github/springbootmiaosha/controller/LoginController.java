package com.github.springbootmiaosha.controller;

import com.github.springbootmiaosha.message.request.LoginRequest;
import com.github.springbootmiaosha.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;




















/**
 * 用户登陆控制层
 *
 * @author lizhangyu
 * @Date 2019-06-18
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginResponse login(LoginRequest request){

    }

}
