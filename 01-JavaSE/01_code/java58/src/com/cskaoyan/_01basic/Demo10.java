package com.cskaoyan._01basic;

/**
 * @author Common-zhou
 * @since 2024-02-29 16:31
 */
public class Demo10 {
    public static void main(String[] args) {
        // 局部变量的使用，分为两步。
        // 声明了之后，不能直接使用，一定要完成初始化之后才能使用。
        // 第一步，局部变量的声明；
        // 数据类型 变量名;
        int flag;
        // System.out.println(flag);

        // 第二步，局部变量的初始化
        flag = 10;

        System.out.println(flag);


        // 声明和初始化，两步可以合成一步。
        int flag2 = 20;

        System.out.println(flag2);
    }

}
