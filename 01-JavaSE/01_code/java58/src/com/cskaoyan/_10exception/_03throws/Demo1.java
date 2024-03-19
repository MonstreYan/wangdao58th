package com.cskaoyan._10exception._03throws;

import java.io.FileNotFoundException;

/**
 * 在方法声明的地方，可以通过throws关键字，告诉别人。我这个方法中，可能会抛出某些异常。
 *
 * @author Common-zhou
 * @since 2024-03-19 11:43
 */
public class Demo1 {

    public static void main(String[] args) throws FileNotFoundException {
        // 一旦一个方法，抛出了一个编译时异常。这时候。你一定要处理
        // 1.接着抛。throws
        // 2.try-cacth

        System.out.println("111");
        test1();
        System.out.println("222");

        // 编译时异常： 会在编译的时候报错。 需要程序员强制手动处理。
        // 出现异常，点 alt + enter  让idea。教你处理

        // 抛的话，抛编译时异常，如果是运行时异常，程序会自己抛。不需要你抛
        // 如果在抛的列表中，有一些父子继承关系的异常。这时候建议抛父类异常。
        // 4.这里，方法抛出了异常没有？ 这个只是声明，告诉别人，我这个方法里面，可能会抛异常。

    }


    public static void test1() throws FileNotFoundException {
        // 这是一个普通的方法
        // 我想通过关键字，告诉别人。 我这个方法中，可能会抛出某些异常。   throws

    }
}
