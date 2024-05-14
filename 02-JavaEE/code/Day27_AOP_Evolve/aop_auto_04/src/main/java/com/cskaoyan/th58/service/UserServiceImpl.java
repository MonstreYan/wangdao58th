package com.cskaoyan.th58.service;

import org.springframework.stereotype.Service;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/14 11:47
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public void login() {
        System.out.println("管理员登录");
    }

    @Override
    public void logout() {
        System.out.println("管理员退出登录");
    }
}
