package com.cskaoyan.th58.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 16:27
 * @Version 1.0
 */
@RestController
public class CookieValueController {

    //为了防止请求头中没有携带cookie数据，获取不到信息的情况
    //在访问当前handle方法时，创建、产生cookie信息
    @GetMapping("cookie1")
    public Object cookie1(HttpServletResponse response){
        //如何创建cookie？？？？？？
        Cookie cookie = new Cookie("username", "kongling");
        response.addCookie(cookie);
        return null;
    }

    //访问下面的代码时，接收客户端传递过来的cookie 先不去使用注解
    @GetMapping("cookie2")
    public Object cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if("username".equals(cookie.getName())){
                    System.out.println(cookie.getValue());
                }
            }
        }
        return null;
    }


    //使用注解 获取名称叫做username的cookie的值，把值赋值给形参value
    @GetMapping("cookie3")
    public Object cookie3(@CookieValue("username") String value){
        System.out.println(value);
        return null;
    }

}
