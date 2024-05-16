package com.cskaoyan.th58.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 11:50
 * @Version 1.0
 */
@Controller
public class HelloController {

    //希望使用service
//    @Autowired
//    UserService userService;

    //该注解的功能和@webServlet的功能等价
    @RequestMapping("/hello")
    //返回json字符串需要使用到的
    @ResponseBody
    public Object hello(){
        return "Hello World";
    }
}
