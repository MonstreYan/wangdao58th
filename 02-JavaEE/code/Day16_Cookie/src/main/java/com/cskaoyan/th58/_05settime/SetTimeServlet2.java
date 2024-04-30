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
@WebServlet("/time2")
public class SetTimeServlet2 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收cookie

        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("time")){
                    //删除cookie
                    //仅仅设置一个maxage=0是无法删除cookie的，为什么呢？
                    //因为cookie是存储在客户端的；而我们这个的代码的意义是服务器上面的一个cookie对象设置了一个属性maxage=0仅此而已
                    //我们需要做的事情是将需要修改的cookie同步给客户端，让客户端把这个cookie给删除了
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    System.out.println(cookie.getValue());
                }
            }
        }
    }
}
