package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 16:36
 * @Version 1.0
 */
@WebServlet("/ss1")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //利用request对象来获取当前请求相关联的session对象
        //第一次访问的时候需要注意什么？第一次访问，因为之前没有相关联的session对象，所以会创建一个
        //创建了session对象，如何和客户端产生关联呢？需要把session的编号通过cookie返回给客户端
        //应该可以看到有一个set-Cookie:JSESSIONID=xxx响应头
        //后续第二次再次访问当前servlet时，或者访问ss2时，还会不会会该响应头呢？不会
        HttpSession session = req.getSession();

        //利用session对象来进行数据共享
        session.setAttribute("username", "kongling");

    }
}
