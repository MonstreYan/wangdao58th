package com.cskaoyan.th58.service;

import com.cskaoyan.th58.mapper.UserMapper;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/11 11:22
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService{

    UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
