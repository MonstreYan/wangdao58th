package com.cskaoyan._06oop3._02interface._02define;

/**
 * 在接口的实现中，可以称呼接口为"父接口"，接口的实现类为"子类"，它们仍然是父子关系。当然多态现象仍然能够发生。
 *
 * @author Common-zhou
 * @since 2024-03-12 10:28
 */
public class Demo2 {
    public static void main(String[] args) {
        // Sparrow这个类。 继承了Animal2  实现了 Fly2接口
        Animal2 animal2 = new Sparrow();
        animal2.eat();

        // 也可以使用接口指向子类。
        Fly2 fly2 = new Sparrow();
        fly2.fly();

    }
}

class Animal2 {
    public void eat() {
        System.out.println("动物进食");
    }
}

interface Fly2 {
    void fly();
}

class Sparrow extends Animal2 implements Fly2 {

    @Override
    public void fly() {
        System.out.println("麻雀飞");
    }

    @Override
    public void eat() {
        System.out.println("麻雀进食");
    }
}
