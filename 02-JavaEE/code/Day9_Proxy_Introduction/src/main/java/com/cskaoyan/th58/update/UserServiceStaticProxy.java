package com.cskaoyan.th58.update;
//增强的类，统计时间的类功能
public class UserServiceStaticProxy implements UserService{

    //使用接口类型来接收
//    UserServiceImpl userService;
    UserService userService;


    public UserServiceStaticProxy(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void addUser() {
        long begin = System.currentTimeMillis();
        //进一步去调用userServiceImpl.addUser
        userService.addUser();
        long end = System.currentTimeMillis();
        System.out.println("add user took :" + (end - begin) + " ms");
    }

    @Override
    public void updateUser() {
        long begin = System.currentTimeMillis();
        userService.updateUser();
        long end = System.currentTimeMillis();
        System.out.println("update user took :" + (end - begin) + " ms");

    }

    @Override
    public void deleteUser() {
        long begin = System.currentTimeMillis();
        userService.deleteUser();
        long end = System.currentTimeMillis();
        System.out.println("delete user took :" + (end - begin) + " ms");

    }
}
