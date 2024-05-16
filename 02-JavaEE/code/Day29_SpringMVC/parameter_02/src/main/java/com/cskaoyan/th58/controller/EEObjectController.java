package com.cskaoyan.th58.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 15:17
 * @Version 1.0
 */
@RestController
public class EEObjectController {

    //接收request response
    //如果希望在handle方法中去接收request、response，那么依然是使用同类型的形参变量去接收即可
    @GetMapping("ee1")
    public Object ee1(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request + " " + response);
        return null;
    }

    //获取ServletContext对象 getServletContext()-----现在还可以调用吗？？？不可以了因为controller没有继承GenericServlet
    // request.getServletContext---filter中就是这么去获取的
    @GetMapping("ee2")
    public Object ee1(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("");
        System.out.println(realPath);
        return null;
    }

    //session对象???怎么办呢？1.方法形参使用HttpServletRequest来接收  2.直接使用HttpSession来接收
    @GetMapping("ss1")
    public Object session1(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("username","kongling");
        return null;
    }

    @GetMapping("ss2")
    public Object session2(HttpSession session){
        Object attribute = session.getAttribute("username");
        System.out.println(attribute);
        return null;
    }


    //获取Cookie？如何获取位于请求头中的Cookie数据，老老实实地用request来接收
    @GetMapping("cookie")
    public Object cookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "::::" + cookie.getValue());
            }
        }
        return null;
    }
}
