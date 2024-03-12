package com.cskaoyan._06oop3._02interface._03use;

/**
 * 类的继承是单继承的，接口的继承是多继承的。
 *
 * @author Common-zhou
 * @since 2024-03-12 11:49
 */
public class Demo4 {
    public static void main(String[] args) {
        Fly42 fly42 = null;
        fly42.fly1();
    }
}

interface Fly4 {
    void fly1();
}

interface Fly41 {
    void fly2();
}

interface Fly42 extends Fly4, Fly41 {

}
