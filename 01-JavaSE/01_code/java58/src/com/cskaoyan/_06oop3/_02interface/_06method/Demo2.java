package com.cskaoyan._06oop3._02interface._06method;

/**
 * 方法的返回值类型，和在方法体中返回具体值（对象）时，不一定要求数据类型完全一致。
 * - 基本类型：方法体中，返回一个具体的值不要求和返回值类型完全一致，存在自动类型提升。
 * - 引用类型： 在方法体中，返回一个对象时不要求就是返回值类型的对象，存在自动向上转型。
 *
 * @author Common-zhou
 * @since 2024-03-12 15:16
 */
public class Demo2 {

    public static int test1() {
        // 返回值如果是一个基本数据类型，在返回具体的值的时候。不一定要求和返回值类型完全一致。

        // short s = 20;
        // return s;

        // 一定是自动类型转换提升才认
        // double d = 1.0;
        // return d;

        return 10;
    }


    public static Animal1 test2() {
        // 返回这个对象，可以
        // return new Animal1();
        // return new Cat1();
        return new Dog1();

    }


}
