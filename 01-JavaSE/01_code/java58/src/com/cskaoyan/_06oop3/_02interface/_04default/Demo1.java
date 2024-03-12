package com.cskaoyan._06oop3._02interface._04default;

/**
 * 接口中的默认方法和静态方法。
 * 默认方法，其实就是Java8加上来的。 加到接口上的。 之前的接口中，只能有抽象方法。 加了默认方法，默认方法就是带方法体的方法
 *
 * @author Common-zhou
 * @since 2024-03-12 14:30
 */
public class Demo1 {
    public void test1() {
        //
    }
}

interface Play1 {
    // 加了一个默认方法。
    public default void test1() {

    }
}
