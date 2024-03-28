package com.cskaoyan._18generic.d08_method;

import org.junit.Test;

/**
 * 协变就是，允许接收该类及该类的子类。
 * 逆变就是，允许接收该类及该类的父类。
 *
 * @author Common-zhou
 * @since 2024-03-28 11:22
 */
public class Demo2Extends1 {

    @Test
    public void test1() {
        // 数组是允许协变的。
        // 协变就是允许接收该类，及该类的子类。

        // 这个写法行不行。
        // 父类指向子类。
        // Animal animal = new Cat();

        User<Animal> user1;
        User<Cat> user2 = new User<>();
        // 这个就是协变。 泛型是不允许协变的。
        // user1 = user2;
    }

    @Test
    public void test2() {
        // 数组是允许协变的。
        // 允许接收该类及该类的子类。
        Animal animal = new Cat();

        // 这个就是协变。
        Animal[] animals1 = new Animal[10];
        Animal[] animals2 = new Cat[10];
    }

    @Test
    public void test3() {
        // 泛型不允许协变,  又想产生类似协变的效果, 又不想引入协变带来的问题(类型不匹配问题)
        // 又不想引入协变带来的问题(类型不匹配问题)

        Animal[] animals1 = new Animal[10];
        animals1[0] = new Animal();
        animals1[1] = new Dog();
        animals1[2] = new Cat();

        Animal[] animals = new Cat[10];
        animals[0] = new Cat();
        animals[1] = new Dog();
    }


}

class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}

class User<T> {

}
