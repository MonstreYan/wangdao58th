package com.cskaoyan.th58._01introduce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/30 14:33
 * @Version 1.0
 */
@WebServlet("/cookie1")
public class CookieServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //去接收客户端携带回来的Cookie信息
        //Cookie的本质是会携带一个Cookie请求头回来，可以直接获取Cookie请求头
        //但是ee规范同样不希望你直接去操作，而是使用ee规范封装过之后的方法
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
        }


        //Cookie是一个class，具有构造函数
        //接下来，将由servlet发送给客户端，会被客户端所保留下来，下次访问时，再次把cookie给携带回来
        Cookie cookie = new Cookie("username", "kongling");
        //Cookie的本质其实就是引入了set-Cookie响应头以及Cookie请求头
//        resp.setHeader("set-Cookie","username=kongling");
        //实际上，ee规范希望你使用下面的方式来去使用cookie
        //利用下面这行代码，我们将需要发送给客户端的cookie信息传递给服务器，服务器会帮助我们去生成对应的响应头
        //后续，我们需要通过抓包验证一下，是否有set-Cookie响应头
        resp.addCookie(cookie);
    }
}
