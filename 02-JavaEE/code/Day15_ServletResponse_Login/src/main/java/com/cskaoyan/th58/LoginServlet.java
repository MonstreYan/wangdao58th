package com.cskaoyan.th58;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/29 15:28
 * @Version 1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //登录的业务逻辑：验证用户输入的用户名、密码是否匹配，如果匹配则跳转到一个页面，如果不匹配，不能够跳转
        //首先得接收用户输入的用户名、密码：使用抓包，抓取；
        //中文乱码问题？？？？
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //可以做一些校验工作

        //后续和数据库中的进行比对校验（有精力的同学可以去做）
        //假设：已经校验通过了   /app/info
        resp.getWriter().println("登录成功，即将跳转至个人中心页面,如果没有跳转，可以点击链接进行手动跳转<a href='" + req.getContextPath() + "/info" + "'>点击跳转</a>");
        resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/info");
    }
}
