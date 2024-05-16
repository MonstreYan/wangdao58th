package com.cskaoyan.th58.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 10:04
 * @Version 1.0
 */
//声明其是一个controller组件
@Controller
@RequestMapping("/admin/auth")
public class AdminAuthController {


    @RequestMapping("/login")
    @ResponseBody
    public Object login(){
        System.out.println("auth login");
        return null;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(){
        System.out.println("auth logout");
        return null;
    }
}
