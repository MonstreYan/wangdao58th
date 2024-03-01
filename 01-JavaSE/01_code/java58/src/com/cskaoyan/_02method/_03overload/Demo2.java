package com.cskaoyan._02method._03overload;

/**
 * 方法的重载：指的是，在一个类中，可以拥有相同的方法名，但是方法名相同，形参一定要不同。.
 * 形参列表不同的三种情况。
 * 1. 形参数量不同
 * 2. 形参数量相同时，形参的数据类型不同
 * 3. 形参数量和数据类型都相同时，形参的数据类型的顺序不同
 *
 * @author Common-zhou
 * @since 2024-03-01 16:34
 */
public class Demo2 {
    // 形参列表不同。
    // 1. 形参数量不同
    public static void test1() {

    }

    // 'test1()' is already defined in 'com.cskaoyan._02method._03overload.Demo2'
    // public static void test1(){
    public static void test1(int num1) {

    }


    // 2. 形参数量相同时，形参的数据类型不同
    public static void test2(int num1, int num2) {
    }

    public static void test2(double d1, double d2) {
    }

    // 3.形参数量和数据类型都相同时，形参的数据类型的顺序不同
    public static void test3(int num1, float num2) {
    }

    public static void test3(float num2, int num1) {
    }

}
