package com.cskaoyan.th58.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 11:44
 * @Version 1.0
 */
//进行组件的实例化，用来去处理web请求
@EnableWebMvc
//springmvc中的controller组件交给springmvc去扫描
@ComponentScan("com.cskaoyan.th58.controller")

//此时还可以先实现一个接口，后续去配置一个web组件时，比较方便
public class SpringMVCConfig implements WebMvcConfigurer {
    //今后需要去设置文件上传组件，那么应该写在这个配置类中
}
