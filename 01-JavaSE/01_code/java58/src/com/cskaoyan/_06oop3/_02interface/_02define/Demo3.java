package com.cskaoyan._06oop3._02interface._02define;

/**
 * 接口不受多继承限制，一个类可以在继承别的类的同时实现接口，而且可以实现多个接口。
 * 类是单继承的。 就是只能 extends一个。
 * 但是接口可以多实现。
 * =================================
 * 实现多个接口，必须要把所有接口的所有方法，全部实现。
 * @author Common-zhou
 * @since 2024-03-12 10:33
 */
public class Demo3 {

}

interface Fly3 {
    void fly();
}

interface Moveable {
    void move();
}

class Animal3 {
    public void eat() {
        System.out.println("动物进食");
    }
}


class Sparrow3 extends Animal3 implements Fly3, Moveable {
    @Override
    public void fly() {

    }

    @Override
    public void move() {

    }
}
