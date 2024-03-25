package com.cskaoyan._15reflect;

/**
 * "com.cskaoyan.bean.User"
 *
 * @author Common-zhou
 * @since 2024-03-25 16:34
 */
public class Demo1Introduct {
    public static void main(String[] args) {
        String beanName = "com.cskaoyan._15reflect.User";
        String userName = "User";

        // “name”  "zs"
        //
        // user.setName();

        // 反射就是用来做这种东西。
        // 把字符串和 Java里面类，关联起来。
        // JVM给我们提供的一个入口，允许我们通过 字符串，创建对象。  设置一些属性。 来调用方法。

    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
