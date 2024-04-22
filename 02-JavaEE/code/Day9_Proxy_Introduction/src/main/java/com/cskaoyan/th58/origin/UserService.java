package com.cskaoyan.th58.origin;
//需要统计以下三个方法的执行时长
//大家思考一下：为什么会需要统计执行时长呢？
//肯定是因为遇到了一些问题，排查究竟哪个步骤出现了问题
//如果比较顺利，排查到了问题，那么接下来，是否意味着就不再需要使用这部分代码了
public class UserService {


    public void addUser(){
        long begin = System.currentTimeMillis();
        System.out.println("add user");
        long end = System.currentTimeMillis();
        System.out.println("add user took " + (end - begin) + "ms");
    }

    public void updateUser(){
        long begin = System.currentTimeMillis();
        System.out.println("update user");
        long end = System.currentTimeMillis();
        System.out.println("update user took " + (end - begin) + "ms");

    }

    public void deleteUser(){
        long begin = System.currentTimeMillis();
        System.out.println("delete user");
        long end = System.currentTimeMillis();
        System.out.println("update user took " + (end - begin) + "ms");

    }
}
