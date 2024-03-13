package com.cskaoyan._06oop3._03inner._03static;

/**
 * 在研究具体的访问前，仍先明确以下两点：
 * 1. 内部类和外部类是"好兄弟"，它们之间的访问不受访问权限限制，包括私有。
 * 2. 静态内部类对象完全不依赖于部围类对象而存在，这意味着，互相访问，不管在哪都要创建对方对象。
 * <p>
 * 1.静态内部类访问外部类
 * 不管是静态内部类中的静态方法还是成员方法，都没有外部类对象存在，需要创建对象访问。语法就直接new对象就可以了。创建好对象以后，用对象名访问即可。如果同名，有谁的引用访问的就是谁的。
 *
 * @author Common-zhou
 * @since 2024-03-13 09:56
 */
public class Demo5 {

}

class OuterClazz5 {
    private String name = "outer";
    public int age = 10;

    static class InnerClazz5 {

        private String name = "inner";
        public int age = 20;

        // 不依赖外部类对象。 所以。在任何时候访问，都要创建对象。
        public void test1() {
            // 成员方法。 没有外部类对象。
            // 需要使用对象， 需要创建一个对象
            OuterClazz5 outerClazz5 = new OuterClazz5();

            String name1 = outerClazz5.name;
            int age1 = outerClazz5.age;

            System.out.println(name);
        }

        public static void test2() {
            OuterClazz5 outerClazz5 = new OuterClazz5();
            String name1 = outerClazz5.name;
            int age1 = outerClazz5.age;

            // 在这能不能直接访问  name
        }

    }
}
