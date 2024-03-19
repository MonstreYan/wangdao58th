package com.cskaoyan._10exception._03throws;

/**
 * throw关键字，可以帮助你，在程序中，主动抛出一个异常。
 *
 * throw。为什么要在代码中显式抛出异常。
 * 简单来说异常就是用来表示Java程序运行过程中的错误(信息)
 *
 * test1 ---> test2   --->  test3   --->   test4 ---  17
 * （return  ）
 * 直接抛出一个异常。然后最后在异常里面，告诉别人问题。
 *
 * @author Common-zhou
 * @since 2024-03-19 14:30
 */
public class Demo3Throw {
    public static void main(String[] args) {
        System.out.println("main before");

        test1();
        System.out.println("main after");

    }

    private static void test1() {

        System.out.println("test1 before");
        test2();
        System.out.println("test1 after");
    }

    private static void test2() {
        System.out.println("test2 before");

        // 可以放入一个String message
        throw new RuntimeException("参数不合法");

        // throw 就是在代码中显式的抛出异常。 在throw之后的语句，执行不到

        // Unreachable statement  ===》
        // System.out.println("test2 end");
    }
}
