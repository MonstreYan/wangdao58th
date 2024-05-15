package com.cskaoyan.th58.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/15 11:44
 * @Version 1.0
 */
@Configuration
//需要扫描除了controller之外的其他的组件,需要将controller和SpringMVC配置类排除在外
@ComponentScan(value = "com.cskaoyan.th58",excludeFilters = {@ComponentScan.Filter(value = {Controller.class, EnableWebMvc.class})})
public class SpringConfig {
    //之前整合mybatis涉及到的所有的组件，写在这里面
}
