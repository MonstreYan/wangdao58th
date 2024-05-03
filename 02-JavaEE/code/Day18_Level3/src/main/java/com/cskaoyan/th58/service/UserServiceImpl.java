package com.cskaoyan.th58.service;

import com.cskaoyan.th58.mapper.UserDBMapper;
import com.cskaoyan.th58.mapper.UserJsonMapper;
import com.cskaoyan.th58.mapper.UserMapper;
import com.cskaoyan.th58.model.User;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/3 15:01
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    //需要进一步去调用mapper
    //存储层、数据层的解决方案
//    UserMapper userMapper = new UserJsonMapper();
    UserMapper userMapper = new UserDBMapper();


    @Override
    public Integer register(User user) {

        return userMapper.register(user);
    }
}
