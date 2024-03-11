package com.cskaoyan._05oop2._02extends._11override;

import com.cskaoyan._05oop2._02extends._03convert.Son;

/**
 * 方法的覆盖
 * 在父类中，可以定义一个方法。 在子类中，也可以定义同名方法。
 * 如果父类和子类中，有同名方法， 这个时候，调用的是父类还是子类的方法
 * 这个就叫做方法的覆盖问题。
 *
 * @author Common-zhou
 * @since 2024-03-11 10:38
 */
public class Demo1 {

    public static void main(String[] args) {
        Father1 father1 = new Father1();
        father1.test1();

        Son1 son1 = new Son1();
        son1.test1();

        Father1 father11 = new Son1();
        father11.test1();
    }

}

class Father1 {
    public void test1() {
        System.out.println("father1 test");
    }
}

class Son1 extends Father1 {
    public void test1() {
        System.out.println("son1 test");
    }
}
