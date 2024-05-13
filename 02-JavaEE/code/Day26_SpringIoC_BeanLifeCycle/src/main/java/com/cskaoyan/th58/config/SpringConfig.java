package com.cskaoyan.th58.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 11:33
 * @Version 1.0
 */
//声明其是一个配置类
@Configuration
//设定扫描的包目录，后续spring便会扫描该包目录，会得到这里面的类的全限定类名信息，利用反射可以创建实例对象
//凡是标注了@Component、@Controller、@Service、@Repository注解，那么均会被解析成为spring容器中的组件对象
@ComponentScan("com.cskaoyan.th58")
public class SpringConfig {
}
