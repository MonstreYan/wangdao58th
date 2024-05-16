package com.cskaoyan.th58.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 16:35
 * @Version 1.0
 */
@RestController
public class SessionAttributeController {

    //往session域里面写入数据 两种方式：1.形参使用HttpServletRequest来接收  2.使用HttpSession来接收
    @GetMapping("ss1")
    public Object ss1(HttpSession session){
        session.setAttribute("username", "kongling");
        return null;
    }

    //从session域里面获取数据
    @GetMapping("ss2")
    public Object ss2(HttpSession session){
        Object attribute = session.getAttribute("username");
        System.out.println(attribute);
        return null;
    }

    //从session域里面获取数据 注解表示的是从session域里面获取一个key=username的值
    @GetMapping("ss3")
    public Object ss3(@SessionAttribute("username") String value){
        System.out.println(value);
        return null;
    }

}
