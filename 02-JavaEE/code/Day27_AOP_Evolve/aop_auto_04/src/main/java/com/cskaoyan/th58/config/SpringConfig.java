package com.cskaoyan.th58.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 14:40
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.cskaoyan.th58")
@EnableAspectJAutoProxy
public class SpringConfig {
}
