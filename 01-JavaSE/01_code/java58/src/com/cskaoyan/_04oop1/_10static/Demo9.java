package com.cskaoyan._04oop1._10static;

/**
 * 类记载时机。
 *
 * @author Common-zhou
 * @since 2024-03-07 11:47
 */
public class Demo9 {
    public static void main(String[] args) {
        // 如果现在。调用一个类的静态成员的时候（变量、方法）。没有类加载， 这时候，有没有记过。
        String demo8StaticVariable = Demo8InvokeRelation.demo8StaticVariable;

        System.out.println(demo8StaticVariable);
    }
}
