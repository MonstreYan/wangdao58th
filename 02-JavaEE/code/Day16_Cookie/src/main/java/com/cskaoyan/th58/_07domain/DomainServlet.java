package com.cskaoyan.th58._07domain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 16:13
 * @Version 1.0
 */
@WebServlet("/dm")
public class DomainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("domain", "ddd");
        //但是这部分代码是不可以在localhost环境下运行的；
        //必须要求在ccc.com环境下才可以运行这段代码；但是这个域名我并没有购买，也没有和本地ip地址关联
        //所以，采取的方式是在hosts文件中去做了映射
        cookie.setDomain("ccc.com");
        resp.addCookie(cookie);
    }
}
