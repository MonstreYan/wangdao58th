package com.cskaoyan._05oop2._03poly;

/**
 * 属性，表现为隐藏。
 * 编译看左边，运行看左边。
 * 左边是什么类型，访问出来的就是它的属性。
 *
 * @author Common-zhou
 * @since 2024-03-11 16:00
 */
public class Demo2 {
    public static void main(String[] args) {
        // 编译看左边，运行看左边、

        Dog2 dog2 = new Dog2();
        // 编译看左边，这是什么类型，就能点出来哪些东西。
        int animalAge = dog2.animalAge;
        // 运行看左边
        System.out.println("dog2.name = " + dog2.name);

        // 父类引用，指向子类对象。
        Animal2 animal2 = dog2;

        System.out.println("animal2.name = " + animal2.name);


    }

}

class Animal2 {
    String name = "animalName";

    int animalAge = 10;
}


class Dog2 extends Animal2 {
    String name = "dogName";
    int dogAge = 5;
}
