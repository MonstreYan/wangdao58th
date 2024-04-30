package com.cskaoyan.th58._05settime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 15:18
 * @Version 1.0
 */
@WebServlet("/time1")
public class SetTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("time", "abcd");

        //设置一个存活时间 单位是秒
        cookie.setMaxAge(180);

        resp.addCookie(cookie);
    }
}
