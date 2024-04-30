package com.cskaoyan.th58._01introduce;

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
@WebServlet("/ss2")
public class SessionServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //利用request对象来获取当前请求相关联的session对象
        HttpSession session = req.getSession();

        System.out.println(session);
        System.out.println(session.getId());

        //利用session对象来进行数据共享
        Object username = session.getAttribute("username");
        System.out.println(username);

    }
}
