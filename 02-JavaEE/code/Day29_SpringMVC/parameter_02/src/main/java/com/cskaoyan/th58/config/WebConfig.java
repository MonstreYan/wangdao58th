package com.cskaoyan.th58.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 10:10
 * @Version 1.0
 */
@EnableWebMvc
@ComponentScan("com.cskaoyan.th58.controller")
public class WebConfig implements WebMvcConfigurer {

    //向容器中去注册一个文件上传解析器
    //这里面需要特别指出的是方法的名称必须叫做multipartResolver
    @Bean
    public MultipartResolver multipartResolver(){
       return new CommonsMultipartResolver();
    }
}
