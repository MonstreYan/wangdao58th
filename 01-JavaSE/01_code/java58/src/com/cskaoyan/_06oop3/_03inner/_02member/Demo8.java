package com.cskaoyan._06oop3._03inner._02member;

/**
 * 1.内部类 访问外部类
 * 2.外部类 访问内部类
 * 3.外部其他类 访问内部类
 * 4.内部类 访问外部其他类。
 *
 * @author Common-zhou
 * @since 2024-03-12 17:41
 */
public class Demo8 {
    public static void main(String[] args) {
        // 外部其他类，访问内部类。
        // 外部其他类要访问成员内部类成员，条件要苛刻的多。由于成员内部类属于外部类的一个成员，
        // 所以首先外部其他类需要有外部类的访问权限，再次还需要成员内部类的访问权限。

        // 现在，在这里有外部类的访问权限。
        OuterClazz8.InnerClazz8 innerClazz8 = new OuterClazz8().new InnerClazz8();

        String innerClazz8Value = innerClazz8.innerClazz8Value;
        // innerClazz8Value.privateInnerClazz8Value;



    }
}

class OuterClazz8 {
    String name;

    /*private*/ class InnerClazz8 {
        String innerClazz8Value = "InnerClazz8111";
        private String privateInnerClazz8Value = "InnerClazz8111";
    }
}
