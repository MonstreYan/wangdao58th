package com.cskaoyan.th58.config;

import org.springframework.context.annotation.ComponentScan;
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
}
