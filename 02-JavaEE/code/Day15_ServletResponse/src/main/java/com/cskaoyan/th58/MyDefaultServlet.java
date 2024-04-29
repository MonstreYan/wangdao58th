package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 15:06
 * @Version 1.0
 */
//@WebServlet("/")
public class MyDefaultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //逻辑：根据用户访问的资源不同，查看当前文件是否位于特定的位置
        //如果在这个位置，则响应出去，返回200状态码
        //如果文件不存在，则返回404状态码
        //如何获取当前请求的请求资源？？？？？
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
        //再补充几个获取请求资源的方法 tips：晚上实现的时候可以参考一下
        String servletPath = req.getServletPath();
        String contextPath = req.getContextPath();
        //  /app/3.png
        System.out.println(requestURI);
        //http://localhost:8080/app/3.png
        System.out.println(requestURL);
        //   /3.png    uri去掉应用名之后的部分
        System.out.println(servletPath);
        //  /app 应用名  应用路径如何获取呢？servletContext.getRealPath("")
        System.out.println(contextPath);
    }
}
