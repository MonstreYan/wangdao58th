package com.cskaoyan.th58.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 10:01
 * @Version 1.0
 */
//配置类
@Configuration
//设定扫描包目录
@ComponentScan("com.cskaoyan.th58")
//开启对于aspectj的支持
@EnableAspectJAutoProxy
public class SpringConfig {
}
