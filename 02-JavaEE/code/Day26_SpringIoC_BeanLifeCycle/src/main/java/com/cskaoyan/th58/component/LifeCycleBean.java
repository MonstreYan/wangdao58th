package com.cskaoyan.th58.component;

import com.cskaoyan.th58.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/13 11:30
 * @Version 1.0
 */
//希望可以把当前类对象放入到spring容器中，应该怎么办？？？？？
@Component
public class LifeCycleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    //需要用到userService的功能，如何引入userService呢？从容器中获取userService对象
   // @Autowired
    UserService userService;

    //在开发过程中，其实没必要这么去写，直接给属性写@Autowired即可，这里面只是为了给大家做一个演示，能够看到过程
    @Autowired
    public void setUserService(UserService userService) {
        System.out.println("调用了setUserService设置属性值");
        this.userService = userService;
    }

    private ApplicationContext context;

    private BeanFactory beanFactory;

    private String beanName;

    public LifeCycleBean() {
        System.out.println("调用了LifeCycleBean无参构造函数实例化对象");
    }

    //可以把容器的引用传递进来，传给当前的bean对象；所以bean对象内部持有了容器的引用
    //当我们实现了该接口（spring怎么知道你有没有实现该接口？？？if(object instanceof BeanNameAware)），那么spring容器便会调用对应的方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用了setBeanFactory：" + beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("调用了setBeanName：" + s);
        this.beanName = s;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用了setApplicationContext：" + applicationContext);
        this.context = applicationContext;
    }
}
