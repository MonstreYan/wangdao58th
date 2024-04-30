package com.cskaoyan.th58._02login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 17:30
 * @Version 1.0
 */
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //分发，分发到login方法中
        String requestURI = req.getRequestURI();
        String op = requestURI.replace(req.getContextPath() + "/user/", "");
        if("login".equals(op)){
            login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        //接收用户提交过来的请求参数信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //需要跳转到info页面，并且还需要和info页面共享用户名信息，所以此时可以使用session域来存储用户的数据
        HttpSession session = req.getSession();
        session.setAttribute("username", username);

        resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/user/info");
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

    private void logout(HttpServletRequest req, HttpServletResponse resp) {
        //注销逻辑
        HttpSession session = req.getSession();
        //调用下面的方法来进行注销
        session.invalidate();
        resp.setHeader("refresh", "2;url=" + req.getContextPath() + "/login.html");
    }

    private void info(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        resp.getWriter().println("welcome:" + username + "<a href='" + req.getContextPath() + "/user/logout" + "'>点击注销</a>");
    }
}
