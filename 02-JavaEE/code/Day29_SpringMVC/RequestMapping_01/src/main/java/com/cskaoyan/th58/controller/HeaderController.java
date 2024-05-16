package com.cskaoyan.th58.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 11:08
 * @Version 1.0
 */
@Controller
public class HeaderController {

    //必须要携带一个叫做username的请求头，否则请求发送失败
    @GetMapping(value = "/header1",headers = "username")
    @ResponseBody
    public Object header1(){

        return null;
    }
}
