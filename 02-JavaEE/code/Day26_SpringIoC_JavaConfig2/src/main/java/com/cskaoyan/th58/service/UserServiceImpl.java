package com.cskaoyan.th58.service;

import com.cskaoyan.th58.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/11 10:26
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{

    //希望从Spring容器中奖当前service实现类取出来的时候，mapper是有值的，不是null

    @Resource
//    @Autowired
    @Qualifier("userMapperImpl")
    UserMapper userMapper;

//    public void setUserMapper(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
}
