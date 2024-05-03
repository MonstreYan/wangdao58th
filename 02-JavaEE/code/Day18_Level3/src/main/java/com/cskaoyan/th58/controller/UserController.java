package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.model.User;
import com.cskaoyan.th58.service.UserService;
import com.cskaoyan.th58.service.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 14:58
 * @Version 1.0
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {

    //业务的解决方案，有几个
    UserService userService = new UserServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("register".equals(op)){
            register(req, resp);
        }else if("login".equals(op)){
            login(req, resp);
        }

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPass = req.getParameter("confirmPass");
        //保障数据都不为空
        if(StringUtils.isEmpty(username)){
            resp.getWriter().println("用户名不能为空");
            return;
        }
        if(StringUtils.isEmpty(password)){
            resp.getWriter().println("密码不能为空");
            return;
        }
        if(StringUtils.isEmpty(confirmPass)){
            resp.getWriter().println("确认密码不能为空");
            return;
        }
        //确认密码和确认密码一致
        if(!password.equals(confirmPass)){
            resp.getWriter().println("两次密码不一致");
            return;
        }
        Integer code = userService.register(new User(username ,password));
        if(code == 404){
            resp.getWriter().println("当前用户名已经被注册");
        }else if(code == 200){
            resp.getWriter().println("注册成功");
        }else {
            resp.getWriter().println("服务器繁忙");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
