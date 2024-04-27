package com.cskaoyan.th58._01basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/27 10:38
 * @Version 1.0
 */
@WebServlet("/req1")
public class RequestServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //希望可以打印处访问当前servlet的请求的请求报文

        //获取请求行
        //请求方法
        String method = req.getMethod();
        //请求资源
        //二者之间有什么样的区别？？？？？ URL是一个完整的路径；uri是去掉访问协议、主机、端口号部分
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        //版本协议
        String protocol = req.getProtocol();
        //GET /app/req1 http://localhost:8080/app/req1 HTTP/1.1
        System.out.println(method + " " + requestURI + " " + requestURL + " " + protocol);
        //获取请求头
        String host = req.getHeader("Host");
        //获取所有的请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        //遍历所有的header的name
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            //所有的请求头键值对
            System.out.println(name + ":" + value);
        }

        //请求体：今天不需要自己去解析处理，知道这么一回事即可
//        req.getInputStream();
    }
}
