package com.cskaoyan.th58._02param;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/27 11:26
 * @Version 1.0
 */
@WebServlet("/param1")
public class ParamServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用方法来获取请求参数
        //key其实就是form表单的name属性
        //无需开发人员自行去解析请求体，服务器会帮助我们解析好
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        //如果我们提交的是类似checkbox这种多个值的场景，那么需要使用下面这个方法
        //  course=java&course=c++
        String[] courses = req.getParameterValues("course");
//        String course = req.getParameter("course");
        System.out.println(username);
        System.out.println(password);
        System.out.println(gender);
        System.out.println(Arrays.toString(courses));
    }
}
