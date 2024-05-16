package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.model.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 11:16
 * @Version 1.0
 */
@RestController
public class JsonResponseController {

    @GetMapping("resp1")
    //此时就不需要再方法的上面添加@ResponseBody注解了
    public Object resp1(){
       return new Result(200, "OK", null);
    }

    @GetMapping("resp2")
    public Object resp2(){
        return new Result(404, "Error", null);
    }
}
