package com.cskaoyan._15reflect;

public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 直接使用 类名.class不会执行静态代码块
        Class<B> b1 = B.class;

        System.out.println("===================");

        // 使用Class.forName() 会执行静态代码块
        Class<?> b2 = Class.forName("com.cskaoyan._15reflect.B");
    }
}

class B {
    static {
        System.out.println("B的静态方法");
    }
}
