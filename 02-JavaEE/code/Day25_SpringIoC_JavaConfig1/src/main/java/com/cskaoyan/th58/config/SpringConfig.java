package com.cskaoyan.th58.config;

import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.mapper.UserMapperImpl;
import com.cskaoyan.th58.service.OrderService;
import com.cskaoyan.th58.service.OrderServiceImpl;
import com.cskaoyan.th58.service.UserService;
import com.cskaoyan.th58.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/11 11:23
 * @Version 1.0
 */
//声明其是一个配置类
@Configuration
public class SpringConfig {

    //你希望向spring容器中去注册哪个组件，那么便编写哪个对象的创建语句
    @Bean
    public UserService userService(UserMapper userMapper){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserMapper(userMapper);
        return userService;
    }

    //Spring处理过程：1.根据方法的返回值类型，得知最终注入到Spring容器中的是OrderService类型的对象
    //2.方法的名称叫做orderService，所以注册到spring容器中的对象的编号为orderService
    //3.方法的形参列表有一个叫做UserMapper，所以spring会扫描容器，从容器中取出一个UserMapper实例对象，在调用当前方法时传递进来
    @Bean
    public OrderService orderService(UserMapper userMapper){
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.setUserMapper(userMapper);
        return orderService;
    }

    @Bean
    public UserMapper userMapper(){
        UserMapper userMapper = new UserMapperImpl();
        return userMapper;
    }
}
