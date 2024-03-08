package com.cskaoyan._05oop2._02extends._03convert;

/**
 * @author Common-zhou
 * @since 2024-03-08 16:40
 */
public class Demo7 {
    public static void main(String[] args) {
        // 强制类型转换什么时候能写。
        Father father = new Son();

        // 这里需要强制类型转换。
        Son son = (Son) father;

        System.out.println(son.name);

    }
}
