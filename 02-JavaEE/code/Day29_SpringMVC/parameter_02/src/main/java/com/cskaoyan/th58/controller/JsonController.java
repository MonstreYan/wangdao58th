package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.model.MarketAdmin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 14:47
 * @Version 1.0
 */
@RestController
public class JsonController {

    //发送json字符串，那么一定要在请求体里面，所以不可以是get请求
    // {"username":"admin123","password":"admin123"}发送的便是这个json字符串
    //形参的名称可以随意，但是要求添加一个注解
    //表示的含义是把请求体里面的数据封装到一个叫做requestBody名称的变量中
    @PostMapping("json1")
    public Object json1(@RequestBody String requestBody){
        System.out.println(requestBody);
        return null;
    }
    // {"username":"admin123","password":"admin123"}发送的便是这个json字符串
    //能够进行封装的前提条件是：形参对象里面的属性值要求和json字符串里面的属性保持一致
    @PostMapping("json2")
    public Object json2(@RequestBody MarketAdmin admin){
        System.out.println(admin);
        return null;
    }

    //发送过来的请求依然下面这个：
    // {"username":"admin123","password":"admin123"}发送的便是这个json字符串
    @PostMapping("json3")
    public Object json3(@RequestBody Map map){
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        System.out.println(username + " " + password);
        return null;
    }
}
