package com.cskaoyan._05oop2._02extends._00homework;

/**
 * 父类  子类。 是一个  is-a关系。 即子类is-a父类。
 * 父类和子类进行类型转换。 这个时候有两种情况
 * Cat   Dog  Animal
 * Animal animal = new Cat();
 * Cat cat = (Cat)animal; // 转换代码
 * Dog dog = (Dog)animal; //  编译报不报错？  不报错；  运行的时候会报错。
 * <p>
 * 父类转子类： 强制类型转换。
 *
 * @author Common-zhou
 * @since 2024-03-11 09:40
 */
public class Demo1 {
    public static void main(String[] args) {
        // 强制类型转换： 就是把父类引用转换成子类引用。

        Animal1 animal1 = new Cat1();
        // 这个就是强制类型转换。
        // 现在编译报不报错？不报错；  运行的时候，报不报错？不报错
        Cat1 cat1 = (Cat1) animal1;

        // 现在编译报不报错？不报错；  运行的时候，报不报错？报错
        Dog1 dog1 = (Dog1) animal1;

        // 什么叫编译报错？
        // 代码如果在没有跑起来的时候，就开始报红，报错。   在代码还没有运行的时候，就叫做编译报错（编译异常）
        // 代码在运行起来的时候的报错，叫做运行时异常。

    }
}


class Animal1 {
}

class Dog1 extends Animal1 {
}

class Cat1 extends Animal1 {
}
