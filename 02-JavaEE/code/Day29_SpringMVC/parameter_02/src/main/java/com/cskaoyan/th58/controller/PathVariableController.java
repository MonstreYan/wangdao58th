package com.cskaoyan.th58.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 15:55
 * @Version 1.0
 */
@RestController
public class PathVariableController {

    //设计一个请求的资源路径：
    // localhost:8080-----> /QbitAI/article/details/138637841
    //1.在编写url时，需要获取参数的位置的地方使用一个{}来占位
    //2.在方法的形参中使用变量来接收,表示的含义是获取username和articleId的值，赋值给对应的形参
    @GetMapping("/{username}/article/details/{articleId}")
    public Object v1(@PathVariable("username") String param1,@PathVariable("articleId") String param2){
        System.out.println(param1 + ":" + param2);
        return null;
    }

    //比如jd的商品详情页面有这样一个地址;item.jd.com/10067897654.html,希望能够获取.html前面的这部分数字
    //如果不借助于当前注解，那么我们需要自行去处理请求资源，将.html替换成空字符串
    @GetMapping("{goodsId}.html")
    public Object v2(@PathVariable("goodsId") String param){
        System.out.println(param);
        return null;
    }

}
