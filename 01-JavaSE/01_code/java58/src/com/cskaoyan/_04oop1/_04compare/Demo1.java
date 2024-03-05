package com.cskaoyan._04oop1._04compare;

/**
 * 局部变量和成员变量的区别。
 * <p>
 * 1.什么是局部变量，什么是成员变量。
 * 局部变量:定义在局部位置的  {}
 * 成员变量： 定义在类里面的变量。 非方法内部。
 *
 * 1.在类中定义的位置不同
 * 1). 局部变量定义在：方法、方法的形参或者代码块结构等局部位置。
 * 2). 成员变量 定义在：类体中、非局部位置的成员位置。
 *
 * @author Common-zhou
 * @since 2024-03-05 11:44
 */
public class Demo1 {
    public static void main(String[] args) {
        int i = 10;
    }


}


class Teacher1 {
    // 成员变量
    public String name;

    public void test1() {
        // 局部变量
        int age;
    }
}
