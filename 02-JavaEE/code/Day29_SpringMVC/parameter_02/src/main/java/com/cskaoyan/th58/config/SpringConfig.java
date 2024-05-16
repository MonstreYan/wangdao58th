package com.cskaoyan.th58.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/16 10:09
 * @Version 1.0
 */
@Configuration
@ComponentScan(value = "com.cskaoyan.th58",excludeFilters = @ComponentScan.Filter({Controller.class, EnableWebMvc.class}))
public class SpringConfig {
}
