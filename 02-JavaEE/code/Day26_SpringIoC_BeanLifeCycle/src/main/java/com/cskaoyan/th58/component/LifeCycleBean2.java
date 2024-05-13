package com.cskaoyan.th58.component;

import com.cskaoyan.th58.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 11:30
 * @Version 1.0
 */
//希望可以把当前类对象放入到spring容器中，应该怎么办？？？？？
@Component
public class LifeCycleBean2 {

    //需要用到userService的功能，如何引入userService呢？从容器中获取userService对象
   // @Autowired
    UserService userService;

    //在开发过程中，其实没必要这么去写，直接给属性写@Autowired即可，这里面只是为了给大家做一个演示，能够看到过程
    @Autowired
    public void setUserService(UserService userService) {
//        System.out.println("调用了setUserService设置属性值");
        this.userService = userService;
    }

    private ApplicationContext context;

    private BeanFactory beanFactory;

    private String beanName;

    public LifeCycleBean2() {
//        System.out.println("调用了LifeCycleBean无参构造函数实例化对象");
    }


    //还有一种自定义init的方式，我们可以不用实现InitializingBean接口，只需要去实现自定义的init方法即可
    //1.导包：javax.annotation  2.添加该注解  spring会帮助我们调用包含该注解的方法
    @PostConstruct
    public void myinit(){
        System.out.println("my init");
    }
}
