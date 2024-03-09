package com.cskaoyan._05oop2._02extends._00homework.b;

/**
 * @author Common-zhou
 * @since 2024-03-09 09:34
 */
public class Student {

    // 在b包下Student类的静态成员方法中可以直接调用clone方法

    public static void test1StaticMethod() {
        // 静态成员方法。
        // 静态能调用静态。 静态不能调用非静态
        // 非静态都能调用。
        // Non-static method 'clone()' cannot be referenced from a static context
        // clone();
    }
}
