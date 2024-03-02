package com.cskaoyan._03array._02memory;

/**
 * @author Common-zhou
 * @since 2024-03-02 11:30
 */
public class Demo2 {
    public static void main(String[] args) {

        int m1 = 10;
        int i = 1;
        test1();

        System.out.println(m1);
        System.out.println(i);
    }

    public static void test1() {
        int i = 10;
        System.out.println(i);
        // System.out.println(m1);
        test2();

    }

    public static void test2() {
        int i = 20;
        System.out.println(i);
        test3();
    }

    public static void test3() {
        int i = 30;
        System.out.println(i);
    }

}
