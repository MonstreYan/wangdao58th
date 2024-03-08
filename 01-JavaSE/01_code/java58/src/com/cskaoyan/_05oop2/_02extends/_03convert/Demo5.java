package com.cskaoyan._05oop2._02extends._03convert;

/**
 * @author Common-zhou
 * @since 2024-03-08 16:23
 */
public class Demo5 {
    public static void main(String[] args) {
        // 在引用数据类型中，类型转换，转换的只是引用的状态，不会改变底层的对象

        Father father;
        Son son = new Son();
        // 转换，只是改变的引用的状态。
        father = son;

    }
}
