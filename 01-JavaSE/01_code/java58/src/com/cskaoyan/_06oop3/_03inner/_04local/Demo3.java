package com.cskaoyan._06oop3._03inner._04local;

/**
 * 外部类的成员方法中，是隐含自身类对象的引用的，并且这个引用编译器会自动加入到局部内部类中。
 * 也就是说， 处在外部类成员方法中的局部内部类，会持有外部类对象的引用。
 * <p>
 * 于是：
 * <p>
 * 1. 可以直接在局部内部类的成员方法中，访问外部类的成员。
 * 2. 如果出现同名，仍然用外部类类名.this指向外部类成员变量
 * 3. 如果全局常量同名，就用类名点区分。
 *
 * @author Common-zhou
 * @since 2024-03-13 10:35
 */
public class Demo3 {

}

class OuterClazz3 {
    private String name = "privateName";

    // 局部内部类在成员方法中： 这个时候是隐含了外部类对象的。
    public void test1() {
        // 局部内部类： 一定定义在局部位置。

        // 在成员方法中，对象有没有？  有。 this，

        System.out.println("this.name = " + this.name);


        class InnerClazz {
            private String name = "inner";

            public void test1() {

                System.out.println(OuterClazz3.this.name);
            }
        }

    }
}
