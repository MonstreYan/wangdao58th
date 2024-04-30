package com.cskaoyan.th58._06path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 15:53
 * @Version 1.0
 */
@WebServlet("/a/s2")
public class PathServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if("path".equals(cookie.getName())){
                    System.out.println(cookie.getValue());
                    cookie.setMaxAge(0);
                    //删除cookie时，需要把创建时设置的path再写一遍，否则不会删除
                    cookie.setPath(req.getContextPath() + "/a/");
                    resp.addCookie(cookie);
                }
            }
        }
    }
}
