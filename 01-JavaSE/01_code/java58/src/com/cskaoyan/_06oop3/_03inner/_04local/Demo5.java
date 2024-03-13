package com.cskaoyan._06oop3._03inner._04local;

/**
 * 一. 在局部内部类的成员方法中，如果想要访问作用域内部的局部变量，那么该变量：
 * 1. 要么直接就用final修饰，是一个局部常量。
 * 2. 要么就是一个事实上的常量，即只能赋值一次，相当于用final修饰它。
 *
 * @author Common-zhou
 * @since 2024-03-13 10:56
 */
public class Demo5 {

}


class OuterClazz5 {
    public void test1() {

        int age = 20;

        // 局部内部类
        class InnerClazz5 {
            public void test1() {
                // 局部内部类的成员方法。
                System.out.println(age);
            }
        }

        // age = 15;
    }
}
