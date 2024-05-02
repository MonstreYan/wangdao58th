package com.cskaoyan.th58.work3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/2 9:50
 * @Version 1.0
 */
@WebServlet("/ss1")
public class SessionServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //额外创建一个cookie
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(180);
        resp.addCookie(cookie);
        session.setAttribute("username","admin123");
    }
}
