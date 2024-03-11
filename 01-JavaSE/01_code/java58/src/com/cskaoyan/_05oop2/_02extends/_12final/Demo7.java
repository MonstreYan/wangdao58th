package com.cskaoyan._05oop2._02extends._12final;

/**
 * @author Common-zhou
 * @since 2024-03-11 15:07
 */
public class Demo7 {

}

class Student7 {
    // Variable 'name' might not have been initialized
    // 对于成员变量加了final。 它就变成了一个成员常量。 这个时候jdk认为，默认值无效。
    // 一定要让你完成对这个常量的赋值。
    final String name = "name";
    final int age;

    final String address;

    {
        age = 20;
    }

    public Student7() {
        this.address = "hubei";
    }

    public Student7(String address) {
        this.address = address;
    }

    // 对于成员变量的赋值方式。
    // 1.默认初始化  （行不通）
    // 2.显式赋值
    // 3.构造代码块
    // 4.构造器

    // 显式赋值和构造代码块赋值。没有特别需要注意的。
    // 但是对于构造器赋值，
    // 要注意， 所有的构造器，均要完成成员常量的赋值。
}
