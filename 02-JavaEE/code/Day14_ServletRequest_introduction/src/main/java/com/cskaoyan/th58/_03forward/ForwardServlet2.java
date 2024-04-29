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
@WebServlet("/fd2")
public class ForwardServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        Object username = req.getAttribute("username");
        System.out.println(username);
        System.out.println("fd2");
    }
}
