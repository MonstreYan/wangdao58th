package com.cskaoyan.th58.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 16:20
 * @Version 1.0
 */
@RestController
public class RequestHeaderController {

    //希望可以获取Host请求头；Accept请求头
    //在接收请求头时，我们直接使用字符串来接收即可，也可以使用一个字符串数组来接收，默认情况下，springmvc会按照,来进行分割，将分割过之后的数据赋值给对应的形参
    @GetMapping("head")
    public Object header(@RequestHeader("Host") String host,@RequestHeader("Accept") String[] accept){
        System.out.println(host + ":::" + Arrays.toString(accept));
        return null;
    }

    //如果没有上述注解，我们可以如何操作？？？？？
    @GetMapping("head2")
    public Object header2(HttpServletRequest request){
        String host = request.getHeader("Host");

        return null;
    }
}
