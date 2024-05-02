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
 * @Date 2024/5/2 16:03
 * @Version 1.0
 */
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先先进行方法的分发
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("login".equals(op)){
            login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //首先是获取用户请求参数信息
        //这里面存在中文乱码问题，引入filter之后，可以不用再此处编写了
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //放入session域
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        resp.getWriter().println("登录成功，即将跳转至个人主页");

        //随后进行页面跳转
        resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/user/info");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("info".equals(op)){
            info(req, resp);
        }else if("logout".equals(op)){
            logout(req, resp);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.getWriter().println("注销成功，即将跳转回登录页面");
        resp.setHeader("refresh", "3;url=" + req.getContextPath() + "/login.html");
    }

    private void info(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //用户信息放入session域，此时再次从session域中获取
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        resp.getWriter().println("welcome " + username + "<a href='" + req.getContextPath() + "/user/logout" + "'>点击注销</a>");
    }
}
