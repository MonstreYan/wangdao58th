package com.cskaoyan._15reflect;

/**
 * @author Common-zhou
 * @since 2024-03-25 17:18
 */
public class Demo4Class {
    public static void main(String[] args) {
        // Class
        // Class是在类加载的过程中，JVM创建出来的。程序员不能手动 new  .
        // 我们要用Class。只能去获取Class对象出来。
        // 获取Class对象的几种方式。
        // 1.对象.getClass();
        // 2.类名.class
        // 3.Class.forName("全限定类名")

        // 现在获取了Class对象之后，需要用Class对象。
        // 1.通过Class对象，获取构造方法
        // 2.通过Class对象，可以获取类中的属性。
        // 3.通过Class对象，可以获取类中的方法。
    }
}
