package com.cskaoyan.th58.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 11:21
 * @Version 1.0
 */
@Controller
public class ModelAndViewController {

    @GetMapping("mav")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/1.jsp");
        //本质便是往request域里面填充数据-----本质便是转发
        modelAndView.addObject("username", "admin123");
        return modelAndView;
    }
}
