package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 11:42
 * @Version 1.0
 */
@WebServlet("/resp1")
public class ResponseServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置响应报文
       //设置响应行
        resp.setStatus(404);

        //设置响应头
        resp.setHeader("Server", "Apache Software Foundation");

        //设置响应体
        resp.getWriter().println("hello world");
    }
}
