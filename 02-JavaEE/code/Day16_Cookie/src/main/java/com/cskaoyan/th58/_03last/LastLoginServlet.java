package com.cskaoyan.th58._03last;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 14:44
 * @Version 1.0
 */
@WebServlet("/last")
public class LastLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要去接收客户端传递过来的Cookie信息
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("last")){
                    String mills = cookie.getValue();
                    resp.getWriter().println(new Date(Long.parseLong(mills)));
                }
            }
        }


        //cookie的value值只可以接收字符串类型，不可以是其他数据类型；value值中不可以包含空格等字符
        long millis = System.currentTimeMillis();
        Cookie cookie = new Cookie("last", millis + "");
        //将产生的Cookie信息以set-Cookie响应头的形式返回给客户端
        resp.addCookie(cookie);
    }
}
