package com.cskaoyan._02method._03overload;

/**
 * 除开上述条件外，其余的任何不同都无法构成方法重载， 经典的错误有：
 * 1. 形参的名字不同，可以构成方法重载✖
 * 2. 返回值类型不同，可以构成方法重载✖
 * 3. 修饰符列表不同，可以构成方法重载✖
 *
 * @author Common-zhou
 * @since 2024-03-01 16:40
 */
public class Demo3 {
    // 1. 形参的名字不同，可以构成方法重载✖ .  只认类型。不认名字。
    // 名字只是给方法的内部使用的。
    // public static void test1(int num1){}
    // public static void test1(int num2){}


    // 2. 返回值类型不同，可以构成方法重载✖
    // public static void test2() {
    // }
    //
    // public static int test2() {
    //     return 0;
    // }

    // 3. 修饰符列表不同，可以构成方法重载✖
    // public static void test3() {
    // }
    //
    // private static void test3() {
    // }

}
