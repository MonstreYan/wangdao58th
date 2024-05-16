package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 10:16
 * @Version 1.0
 */
@Controller
@RequestMapping("admin/user")
public class AdminUserController {

    //去处理/admin/user/login的请求，但是请求方法必须时post请求方法
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(){
       return new Result(200, "OK", null);
    }
}
