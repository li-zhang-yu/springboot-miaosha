package com.github.springbootmiaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试集成thymeleaf
 *
 * @author lizhangyu
 * @Date 2019-08-06
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";
    }

}
