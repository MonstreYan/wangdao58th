package com.cskaoyan._05oop2._02extends._08init;

/**
 * 在子类对象初始化的时候，对父类的构造方法调用，分两种情况
 * 1.如果子类没有调用父类构造方法。==》 这时候会隐式调用
 * 2.如果子类调用了父类构造方法。==》 这时候直接调用
 *
 * 所以子类就一个原则， 我一定要调用父类的构造方法。
 *
 * @author Common-zhou
 * @since 2024-03-09 10:22
 */
public class Demo4 {
    public static void main(String[] args) {
        Dog4 dog4 = new Dog4();
    }
}

class Animal4 {
    String name;

    // public Animal4() {
    // }

    public Animal4(String name) {
        this.name = name;
    }
}


class Dog4 extends Animal4 {
    // 现在，有没有调用父类的构造方法？
    // There is no default constructor available in 'com.cskaoyan._05oop2._02extends._08init.Animal4'
    public Dog4() {
        super("1111");
    }
}
