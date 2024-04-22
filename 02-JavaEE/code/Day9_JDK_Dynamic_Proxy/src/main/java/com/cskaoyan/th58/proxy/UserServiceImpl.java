package com.cskaoyan.th58.proxy;
//委托类
public class UserServiceImpl implements UserService{
    @Override
    public int addUser() {
        System.out.println("add user");
        return 0;
    }

    @Override
    public int updateUser() {
        System.out.println("update user");
        return 0;
    }

    @Override
    public int deleteUser() {
        System.out.println("delete user");
        return 0;
    }
}
