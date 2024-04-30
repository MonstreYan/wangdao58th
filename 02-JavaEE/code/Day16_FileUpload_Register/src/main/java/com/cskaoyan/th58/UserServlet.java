package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 10:35
 * /user/app/xx/aaa/register
 * @Version 1.0
 */
@WebServlet("/user/*")
//该注解的功能是让服务器帮助我们去解析请求里面的文件数据，处理过之后再次封装回req对象中
@MultipartConfig
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //不要着急，上来就在doPost里面写注册逻辑，因为后面可能还会有其他方法也需要使用doPost来分发
        //因为这里面含有*，所以不可以使用
//        req.getServletPath()
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("register".equals(op)){
            register(req, resp);
        }
    }

    //注册的业务逻辑
    //获取接收用户提交过来的请求参数信息（借助于请求报文）；初步校验比对，保证信息的唯一性，存储到数据库，给页面一个回执信息
    private void register(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
