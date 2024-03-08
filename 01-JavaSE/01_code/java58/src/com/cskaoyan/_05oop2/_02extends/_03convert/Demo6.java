package com.cskaoyan._05oop2._02extends._03convert;

/**
 * @author Common-zhou
 * @since 2024-03-08 16:29
 */
public class Demo6 {
    public static void main(String[] args) {
        // 在引用数据类型转换中，分两类
        // 1.自动类型转换
        // 把子类对象，转换为父类引用。 因为子类is-a父类，所以这个过程，可以自动完成转换。
        Son son = new Son();
        // 父类类型
        Father father;

        // 这个就是自动类型转换。 把子类引用转换为父类引用。  我们不需要写额外代码来处理。
        father = son;

        System.out.println("=============================");

        // 2.强制类型转换
        // 想把一个父类引用，转换为子类引用，这时候就是强制类型转换。
        Father father1 = new Father();

        // 这个就是强制类型转换的语法。
        // 子类类型 对象名 = (子类类型)父类引用;
        // 一般情况下， 父类不能强制转换为子类。 如果强制转换，会出异常。
        Son son1 = (Son) father1;


    }
}
