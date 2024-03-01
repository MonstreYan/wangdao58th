package com.cskaoyan._02method._03overload;

/**
 * 方法重载中的就近原则
 *
 * @author Common-zhou
 * @since 2024-03-01 17:01
 */
public class Demo5 {
    // 方法1
    // public static void test(int a) {
    //     System.out.println("int method call");
    // }

    // 方法2
    public static void test(double a) {
        System.out.println("double method call");

    }

    // 方法3
    public static void test(float a) {
        System.out.println("float method call");
    }

    public static void main(String[] args) {
        // 现在调用的是哪个方法。
        // 按照就近原则，如果有int，就用int的； 如果没有int，
        // int  float  double
        test(10);

        // test1(1.0, 10);
        // test1(10, 1.0);
        // test1(10, 10);
    }


    // 方法1
    public static void test1(int a,double b){}
    // 方法2
    public static void test1(double a,int b){}
}
