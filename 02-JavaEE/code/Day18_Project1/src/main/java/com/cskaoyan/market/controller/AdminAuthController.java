package com.cskaoyan.market.controller;

import com.cskaoyan.market.util.JacksonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 16:26
 * @Version 1.0
 */
@WebServlet("/admin/auth/*")
public class AdminAuthController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/admin/auth/", "");
        if("login".equals(op)) {
            login(req, resp);
        }
    }

    //登录的流程：获取接收用户的请求参数信息；校验，系统中进行比对(调用service、mapper)，根据比对的结果返回一个回执信息
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //不能用，因为不是key=value&key=value格式
//        String username = req.getParameter("username");
        //下面两个方法都是可以获取请求体的，只不过第二个又进一步包装了一下，可以使用readLine方法，更加简化一些
//        req.getInputStream();
        String requestBody = req.getReader().readLine();
        System.out.println(requestBody);
        //可以使用之前介绍的方法，objectMapper.readValue使用一个对象来接收，便可以完成数据的封装工作
        //但是如果使用上述方案，那么需要去构建一个类Admin，此时我不想去额外再去构建一个类
        //可以使用objectMapper提供的另外的功能，将json字符串解析成为一棵树，去读取指定的节点
        //一般情况下，如果json字符串里面额度属性非常少，比如就一两个，那么此时额外构造一个类，就比较不划算，此时可以使用下面的方法来进行
        String username = JacksonUtil.parseString(requestBody, "username");
        String password = JacksonUtil.parseString(requestBody, "password");
        System.out.println(username + " " + password);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
