package com.cskaoyan._06oop3._03inner._03static;

/**
 * 静态内部类： 就是一个独立的类，只不过这个类借助于外部类保护自己。 其余没啥区别
 *

 *
 * @author Common-zhou
 * @since 2024-03-13 09:49
 */
public class Demo3 {
}


class OuterClazz3 {
    static class InnerClazz3 {
        // 成员变量
        int age = 10;
        static String name = "zhangsan";

        {
            age = 11;
        }

        static {
            name = "lisi";
        }

        public InnerClazz3(int age) {
            this.age = age;
        }

        // 成员方法
        public void test1() {
            System.out.println("test1");
        }

        public static void test2() {
            System.out.println("test2 static");
        }
    }
}
