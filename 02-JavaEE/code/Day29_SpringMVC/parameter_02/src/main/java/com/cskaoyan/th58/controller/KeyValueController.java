package com.cskaoyan.th58.controller;

import com.cskaoyan.th58.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 11:27
 * @Version 1.0
 */
@RestController
public class KeyValueController {

    // /param1?username=admin&password=admin123&gender=male&age=25&course=java&course=python
    //如果发送的是上述的这样的请求，那么在java ee阶段，需要使用request.getParameter/getParameterValues来获取接收
    //无关是get还是post请求，只要满足key=value&key=value数据类型，那么均可以使用上述的方法
    //在springmvc中，无需使用上述的方式来操作；只需要在handle方法中编写对应的名称的形参来接收即可；形参的类型不要求一定是String类型，使用可以接受的类型来接收即可
    @GetMapping("/param1")
    public Object param1(String username, String password, String gender, Integer age, String[] course){
        System.out.println(username + " " + password + " " + gender + " " + age + " " + Arrays.toString(course));
        return null;
    }
    // /param2?birthday=1999/10/01
    //如果时间格式不是上述的时间格式，而是yyyy-MM-dd格式，那么应该怎么办？？？？
    @GetMapping("/param2")
    public Object param2(Date birthday){
        System.out.println(birthday);
        return null;
    }

    // /param3?birthday=1999-10-01
    @GetMapping("/param3")
    public Object param3(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday){
        System.out.println(birthday);
        return null;
    }


    // /param4?username=admin&password=admin123&gender=male&age=25&course=java&course=python&birthday=1999-10-01
    @GetMapping("/param4")
    public Object param4(User user){
        System.out.println(user);
        return null;
    }
}
