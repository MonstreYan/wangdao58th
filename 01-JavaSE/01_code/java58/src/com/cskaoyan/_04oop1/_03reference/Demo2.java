package com.cskaoyan._04oop1._03reference;

/**
 * @author Common-zhou
 * @since 2024-03-05 11:13
 */
public class Demo2 {
    public static void main(String[] args) {
        // 基本数据类型，这是一个数据类型。

        // JVM是否知道  int 占多少空间。  以及能进行哪些操作？   ==》知道。
        int a = 10;

        // 自定义的类。是一种数据类型（引用数据类型。）
        // JVM现在，是否需要知道。 有哪些数据，以及有哪些合法操作？

        Student2 student2 = new Student2();

        // 所以在对某个类做任何操作之前，都需要让JVM来"认识"这个类型。
        // 在Java中，把JVM"认识"一个类的过程，称之为类加载

        // student2是一个对象。 这个东西需要再内存上存上。 由于它不是一个内置的数据类型。
        // 所以JVM在最开始的时候，不知道它的结构，也不知道它占多大空间。
        // 一定有一个过程。让JVM认识这个类。 在Java中，把JVM"认识"一个类的过程，称之为类加载
    }
}


class Student2 {

}
