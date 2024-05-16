package com.cskaoyan.th58;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 11:01
 * @Version 1.0
 */
@Controller
public class HelloController {

    //希望当前请求方法时，可以返回一个json字符串
    //实现请求和方法的映射
    @RequestMapping("/hello")
    //返回一个json字符串
    @ResponseBody
    public Object hello(){

        Result ok = new Result(200, "OK", null);

        //之前在项目一种返回一个json字符串非常麻烦；需要把对象转换成json字符串；需要利用response放置在响应体中
        return ok;
    }
}
