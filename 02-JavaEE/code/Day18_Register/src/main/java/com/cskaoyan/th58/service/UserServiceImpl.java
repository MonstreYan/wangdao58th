package com.cskaoyan.th58.service;

import com.cskaoyan.th58.mapper.UserJsonMapper;
import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.model.User;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 14:43
 * @Version 1.0
 */
public class UserServiceImpl implements UserService{

    UserMapper userMapper = new UserJsonMapper();

    @Override
    public Integer register(User user) {
        return userMapper.register(user);
    }

    @Override
    public void function() {
        //方案一：
//        userMapper.update();
//        userMapper.insert();
    }
}
