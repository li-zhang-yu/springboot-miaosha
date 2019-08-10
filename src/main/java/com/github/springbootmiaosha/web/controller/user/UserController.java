package com.github.springbootmiaosha.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户控制层
 *
 * @author lizhangyu
 * @Date 2019-08-09
 */
@Controller
public class UserController {

    @GetMapping("/user/login")
    public String loginPage(){
        return "user/login";
    }

    @GetMapping("user/center")
    public String centerPage(){
        return "user/center";
    }
}
