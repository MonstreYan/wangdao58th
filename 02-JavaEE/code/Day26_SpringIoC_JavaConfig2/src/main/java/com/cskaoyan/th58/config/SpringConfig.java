package com.cskaoyan.th58.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 9:57
 * @Version 1.0
 */
//首先声明它是一个配置类
    //添加一个@ComponentScan注解：设定扫描的包目录(可以递归的方式扫描到所有的类，那么哪些需要放入到spring容器中呢)，需要放入到Spring容器中的组件对象设定对应的注解即可
    //我们需要将那些需要放入到spring容器中的类头上标注@Component注解，凡是标注了该注解，那么便会被spring所处理，因为spring得知所有类的全限定类名，根据标注了该注解，通过反射实例化对象，放入spring容器中
    //关于@Component注解有一个额外的说明：为了能够很形象地表示出这些组件的功能定位，spring额外制定了一系列的其他注解，比如@Controller、@Service、@Repository注解，这几个注解其实就是对应的是三层架构中的三个组件
    //使用上述三个注解和@Component注解的功能完全等价；不在三层架构组件中的对象，直接标注@Component即可
    //使用这种方式，如何将对象和对象之间产生关联呢？需要使用一个叫做@Autowired注解，表示的是从容器中获取指定类型的对象
    //如果符合同一个类型的实例对象有多个，那么使用@Qualifier(id)，这种方式注册的组件的编号是什么呢？类名的首字母小写
@Configuration
@ComponentScan("com.cskaoyan.th58")
public class SpringConfig {
}
