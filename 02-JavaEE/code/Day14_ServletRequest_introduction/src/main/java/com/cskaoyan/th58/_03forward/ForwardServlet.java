package com.cskaoyan.th58._03forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 11:17
 * @Version 1.0
 */
@WebServlet("/fd")
public class ForwardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //当前servlet调用fd2，另外一个serlvet
        //向tomcat发送一条指令，告诉tomcat去调用另外一个servlet fd2
        System.out.println("fd1");
        req.setAttribute("username","zhangsan");
        req.getRequestDispatcher("/fd2").forward(req, resp);
    }
}
