package com.cskaoyan.th58.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 9:41
 * @Version 1.0
 */
//声明它是一个配置类
@Configuration
//设定扫描包目录
@ComponentScan("com.cskaoyan.th58")
//开启对于aspectj支持的开关，默认是关闭状态的
@EnableAspectJAutoProxy
public class SpringConfig {
}
