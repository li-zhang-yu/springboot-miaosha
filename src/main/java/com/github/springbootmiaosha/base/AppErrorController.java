package com.github.springbootmiaosha.base;


import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web错误全局配置
 *
 * @author lizhangyu
 * @Date 2019-08-06
 */
@Controller
public class AppErrorController implements ErrorController {

    /**
     * 错误路径
     */
    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    public AppErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    /**
     * web页面错误处理
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    private String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";
    }

}
