package com.cskaoyan.market.preview;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/10 14:39
 * @Version 1.0
 */
public class UserServiceImpl implements UserService{
    @Override
    public int addUser() {
        System.out.println("add user");
        return 0;
    }

    @Override
    public void selectUser() {
        System.out.println("select user");
    }
}
