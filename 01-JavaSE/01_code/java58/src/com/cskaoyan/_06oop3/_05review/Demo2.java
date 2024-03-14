package com.cskaoyan._06oop3._05review;

/**
 * @author Common-zhou
 * @since 2024-03-14 10:12
 */
public class Demo2 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int a = 10;

        test2();
    }

    private static void test2() {
        User user = new User("zhangsan");

    }
}

class User {
    String name;
    static String country = "China";

    public User(String name) {
        this.name = name;
    }
}
