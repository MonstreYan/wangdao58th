package com.cskaoyan._06oop3._03inner._03static;

/**
 * 2.外部类访问静态内部类成员
 * 不管是静态外部类中的静态方法还是成员方法，都没有内部类对象存在，
 * 需要创建对象访问。语法就直接new对象就可以了。创建好对象以后，用对象名访问即可。如果同名，有谁的引用访问的就是谁的。
 *
 * @author Common-zhou
 * @since 2024-03-13 10:02
 */
public class Demo6 {

}


class OuterClazz6 {
    static class InnerClazz6 {
        private String name = "inner";
        public int age = 10;
    }


    // 成员方法中来访问内部类对象
    public void test1() {
        // 在外部类中，都没有静态内部类对象。这时候，需要方法，创建静态内部类对象
        InnerClazz6 innerClazz6 = new InnerClazz6();

        System.out.println("innerClazz6.name = " + innerClazz6.name);
        System.out.println("innerClazz6.age = " + innerClazz6.age);
    }

    public static void test2() {
        // 外部类的静态方法中，也没有静态内部类对象。 也需要创建对象

        InnerClazz6 innerClazz6 = new InnerClazz6();
        String name = innerClazz6.name;
        int age = innerClazz6.age;
    }

}
