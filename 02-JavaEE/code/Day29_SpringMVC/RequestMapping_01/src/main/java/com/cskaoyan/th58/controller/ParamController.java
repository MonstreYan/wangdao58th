package com.cskaoyan.th58.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 11:01
 * @Version 1.0
 */
@Controller
public class ParamController {

    // /param1?username=admin&password=admin123要求必须要携带username、password请求参数
    @RequestMapping(value = "/param1",params = {"username", "password"},method = RequestMethod.GET)
    @ResponseBody
    public Object param1(){
        return null;
    }

    //除了使用上述方法之外，还可以使用下面的方式
    // /param1?username=admin&password=admin123要求必须要携带username、password请求参数
    @GetMapping(value = "/param2",params = {"username", "password"})
    @ResponseBody
    public Object param2(){
        return null;
    }
}
