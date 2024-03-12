package com.cskaoyan._06oop3._03inner._02member;

/**
 * 内部类成员特点。
 * 1. 可以定义普通成员变量，成员方法。但没有静态声明（包括静态变量，静态方法，静态代码块）。
 * 在JDK16之后，允许定义静态声明。
 * 2. 有构造器，有构造代码块。
 * 3. 可以有静态全局常量。
 *
 * @author Common-zhou
 * @since 2024-03-12 16:13
 */
public class Demo2 {

}


class OuterClazz2 {
    /// 内部类的成员特点。
    class InnerClazz2 {
        private String name = "zhangsan";
        public int age;

        public static final String ADDRESS = "111";

        // static String address = "12356";
        // static {
        //     address = "6666";
        // }

        {
            age = 10;
        }

        public InnerClazz2(String name) {
            this.name = name;
        }

        public InnerClazz2(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
