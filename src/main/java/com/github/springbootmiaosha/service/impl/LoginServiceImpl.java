package com.github.springbootmiaosha.service.impl;

import com.github.springbootmiaosha.dao.UserMapper;
import com.github.springbootmiaosha.entity.User;
import com.github.springbootmiaosha.message.request.LoginRequest;
import com.github.springbootmiaosha.message.response.LoginResponse;
import com.github.springbootmiaosha.service.LoginService;
import com.github.springbootmiaosha.util.DateUtil;
import com.github.springbootmiaosha.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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
            newUser.setAddTime(new Date());
            userMapper.insertByUsernameAndPassword(newUser);
        }
        response.setCode(0);
        response.setMsg("success");
        return response;
    }

    /**
     * 获取用户列表
     * @return
     */
    @Override
    public PageBean<User> getUserList() {
        List<User> dataList = userMapper.getUserList();
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setDataList(dataList);
        return pageBean;
    }

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 根据用户的ip获取用户的地址
     *
     * @param request
     * @return
     */
    public String getGuessPosition(HttpServletRequest request){

        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");

        String ip = null;
        if (realIp == null) {
            if (forwarded == null) {
                ip = remoteAddr;
            } else {
                ip = remoteAddr + "/" + forwarded.split(",")[0];
            }
        } else {
            if (realIp.equals(forwarded)) {
                ip = realIp;
            } else {
                if(forwarded != null){
                    forwarded = forwarded.split(",")[0];
                }
                ip = realIp + "/" + forwarded;
            }
        }
        return ip;
    }
}
