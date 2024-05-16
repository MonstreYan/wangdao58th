package com.cskaoyan.th58.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 16:09
 * @Version 1.0
 */
@RestController
public class RequestParamController {

    //携带了请求参数/p1?username=admin&password=admin123
    //不使用注解
    @GetMapping("p1")
    public Object param1(String username, String password){
        System.out.println(username + ":" + password);
        return null;
    }

    //使用注解
    @GetMapping("p2")
    public Object param2(@RequestParam("username") String u,@RequestParam("password") String p){
        System.out.println(u + ":" + p);
        return null;
    }

    //该注解也是有一些功能的，比如设置在没有传递参数的时候，设置一个默认值
    //比如之前的项目一种/admin/goods/list?page=1&limit=20&sort=add_time&order=desc
    //其实可以理解这个注解设置上述page limit sort order的默认值，如果没有传递的情况下，设置一个默认值，也不会使得程序出错
    //可以设置一个默认值，/admin/goods/list没有携带请求参数，但是此时依然可以获取到值，便是设置的默认值
    @GetMapping("admin/goods/list")
    public Object param3(@RequestParam(value = "page",defaultValue = "1") Integer page,
                         @RequestParam(value = "limit",defaultValue = "20") Integer limit,
                         @RequestParam(value = "sort",defaultValue = "add_time") String sort,
                         @RequestParam(value = "order", defaultValue = "desc") String order){
        System.out.println(page + " " + limit + " " + sort + " " + order);
        return null;
    }

}
