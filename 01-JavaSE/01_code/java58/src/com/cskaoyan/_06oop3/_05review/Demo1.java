package com.cskaoyan._06oop3._05review;

/**
 * @author Common-zhou
 * @since 2024-03-14 10:03
 */
public class Demo1 {
    public static void main(String[] args) {
        // 1.基本数据类型，初始化数组。
        int[] nums = new int[10];

        // nums里面有没有值？
        // 有值。 值是0.

        // 2.String[] strings = new String[10];
        String[] strings = new String[10];

        // strings[0] ===> null
        // 为啥会出空指针：   null.test1();  null.length


        // users[0] 位置是什么数据？
        // users[0].setUserName("zhangsan"); ==》 空指针
        // users[0] = new User();
        // User[] users = new User[10];

        // for (int i = 0; i < users.length; i++) {
        //
        //     // users[0] = new User();
        //     // users[0].setUserName("zhangsan");
        //
        //     User user = new User();
        //     user.setUserName("zhangsan");
        //     user.setPassword("zhangsan");
        //     users[0] = user;
        // }


    }
}
