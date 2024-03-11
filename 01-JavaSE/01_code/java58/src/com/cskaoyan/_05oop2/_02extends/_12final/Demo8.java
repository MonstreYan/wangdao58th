package com.cskaoyan._05oop2._02extends._12final;

/**
 * 静态成员常量用的比较多。
 * <p>
 * 一般用它来做常量，而且全局就一份，符合全局常量的定义。
 * 这个东西在工作过程中，用的比较多。
 *
 *
 * @author Common-zhou
 * @since 2024-03-11 15:15
 */
public class Demo8 {

}

class Student8 {
    // 静态成员变量
    // 静态成员常量
    public final static String NAME = "zhangsan";

    // 静态成员常量的取值，也不能依赖于默认值。  ===> 写一个静态成员常量，必须要给它赋值。
    public final static String ADDRESS;

    // 静态成员变量的赋值方式，有哪几种方法
    // 1.显式赋值
    // 2.静态代码块

    static {
        ADDRESS = "hubei";
    }
}
