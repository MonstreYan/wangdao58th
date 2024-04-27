package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/27 10:38
 * @Version 1.0
 */
public class RequestServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //希望可以打印处访问当前servlet的请求的请求报文

        //获取请求行
        //请求方法
        String method = req.getMethod();
        //请求资源
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        //版本协议
        String protocol = req.getProtocol();

        //获取请求头
        String host = req.getHeader("Host");
        //获取所有的请求头
        
    }
}
