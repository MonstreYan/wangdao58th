package com.cskaoyan._05oop2._02extends._05level;

/**
 * 在Java中，如果一个类。没有使用extends关键继承某个类。那么它一定是Object的一个子类。
 * @author Common-zhou
 * @since 2024-03-08 17:18
 */
public class Demo2 {
    public static void main(String[] args) {
        // Demo2没有任何显式父子继承关系，但是一定是Object的一个子类。
        Demo2 demo2 = new Demo2();
        // demo2.clone();

        // demo2.hashCode();
    }

}
