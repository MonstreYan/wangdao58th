package com.cskaoyan.th58.service;

import com.cskaoyan.th58.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/11 11:22
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    @Qualifier("userMapperImpl2")
    UserMapper userMapper;

    //下面这种方式其实有一些繁琐，我们可以将set方法省略，直接利用属性进行赋值

//    @Autowired
//    public void setUserMapper(@Qualifier("userMapperImpl2") UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
}
