package com.cskaoyan._12io._03otherstream;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-21 15:53
 */
public class Demo3 {

    @Test
    public void test1() {
        // 什么叫序列化，什么叫反序列化。

        // String   int  float

        // 序列化流： 就是将一个对象序列化成一个数据（变成二进制的数据，变成可以存储，可以传输的数据）
        // 转换成一个可以存储的东西。

        // - 序列化: 把对象数据转为二进制数据, 存到文件的过程
        // - 反序列:(序列化的逆过程) 把二进制数据还原回对象数据的过程

        User user = new User("景天", 18);
        // 如果我把这个user。转换成了一个二进制数据。然后存储起来。
        //
    }

    @Test
    public void test2() {
        // 今后还会碰到这个概念。如何把一个对象，在网络上传输。

        // user
        // 转换成一个到处都可以用的对象。

        // 对于一个对象来说，最重要的是什么？ ===》 属性（数据）
        // new User("景天", 18);
        // {}表示一个对象。
        // {name=景天， age=18}

        // new User("长风", 19, new Address("湖北", 42));
        // {name=长风， age=19， address={name=湖北， id=42}}

        // json
        // {name=长风， age=19， address={name=湖北， id=42}, hobbies=["sing", "dance", "rap"]}
        // json： 就是一种用字符串表示对象的方式。 只要用字符串表示了一个对象，有什么好处？
        // 对象这个东西。网络传输没用。
        // 字符串。 在网络的任何位置都可以传输。   前端。后端，文件

        // 把对象，转换为字符串。  这个就叫做序列化。


        // =========================================================
        // 序列化和反序列化的概念一定要懂。

    }
}


class User {
    String name;
    int age;
    Address address;
    String[] hobbies;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


class Address {
    String name;
    int id;

    public Address(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
