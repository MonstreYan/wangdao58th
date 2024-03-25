package com.cskaoyan._15reflect;

/**
 * Class对象，就是JVM内部将所有的信息存储起来的一个对象。
 * 比如，你有一个User类。 JVM在将这个User类加载进来后，会在JVM里，创建一个对象，用来表示User。
 * Class对象里面，有属性。方法，构造方法， 是否有父类， 是否实现接口。
 * <p>
 * 反射的起点，就是Class对象。
 * <p>
 * - 对象.getClass()
 * - 类名.class
 * - Class.forName(String className)  全限定名
 * - ClassLoader里的loadClass(String className)
 *
 * @author Common-zhou
 * @since 2024-03-25 17:06
 */
public class Demo2Class {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.对象.getClass()

        User2 user2 = new User2();

        Class<? extends User2> aClass = user2.getClass();

        System.out.println("aClass.getName() = " + aClass.getName());
        System.out.println("aClass.getPackage() = " + aClass.getPackage());

        // 2.类名.class
        Class<User2> user2Class = User2.class;

        //  3.Class.forName(String className)
        Class<?> aClass1 = Class.forName("com.cskaoyan._15reflect.User2");
        System.out.println(aClass1);

        // 所有方式，只要获取的是User2同一个类。 那么它们的class一定是同一个。
        //无论通过什么方式获取的字节码文件对象 都是同一个

        System.out.println(user2Class == aClass1);


    }
}

class User2 {
    String name;
    int age;

    public void test1() {
        System.out.println(name);
    }

    private void test2() {
        System.out.println("test2 method");
    }
}
