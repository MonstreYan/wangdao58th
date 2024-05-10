package com.cskaoyan.market.preview;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/5/10 14:41
 * 静态代理类对象
 * @Version 1.0
 */
public class UserServiceProxy implements UserService{

    //持有委托类对象
//    UserServiceImpl userService;

    UserService userService;


    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public int addUser() {
        //前面做一些事情
        userService.addUser();
        //后面做一些事情
        return 0;
    }

    @Override
    public void selectUser() {
        //前面做一些事情
        userService.selectUser();
        //后面做一些事情
    }
}
