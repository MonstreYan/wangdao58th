package com.cskaoyan._06oop3._03inner._04local;

/**
 * 局部内部类在外部类的静态成员方法中
 * 静态方法中就不存在任何对象了，其中的局部内部类也就不会持有引用了。想要访问外部类成员，就需要创建对象了。
 *
 * @author Common-zhou
 * @since 2024-03-13 10:38
 */
public class Demo4 {

}

class OuterClazz4 {

    String name = "name";

    public static void test1() {
        // 这有没有外部类对象

        class InnerClazz4 {
            public void test1() {
                // System.out.println(name);
            }
        }
    }
}
