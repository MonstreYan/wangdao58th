package com.cskaoyan._06oop3._03inner._02member;

/**
 * 外部类访问成员内部类成员(重点)
 * <p>
 * 第二，外部类访问成员内部类成员，要分两种情况：
 * 1.外部类的成员方法中访问成员内部类成员：
 * 2.外部类的静态成员方法中访问成员内部类成员：
 * 在外部类静态方法中，要访问成员内部类成员。 一定要创建内部类对象出来，才能访问。
 * 但是，内部类对象，又依赖外部类对象。  在外部类的静态方法中， 没有外部类对象。 只能先创建一个外部类对象， 再创建内部类对象
 *
 * @author Common-zhou
 * @since 2024-03-12 17:27
 */
public class Demo7 {

}


class OuterClazz7 {

    public String m1 = "m1InOuter";
    public String m2 = "m2InOuter";


    public void test1() {
        // 成员方法，来访问内部类成员
        // 要用内部类对象。 一定要创建对象。
        // 要创建内部类对象 ===》  一定要有一个外部类对象 ===》 在成员方法中，有
        InnerClazz7 innerClazz7 = new InnerClazz7();
        System.out.println("innerClazz7.privateStringName = " + innerClazz7.privateStringName);
        System.out.println("innerClazz7.defaultStringName = " + innerClazz7.defaultStringName);

        // 创建对象后，直接用对象名点访问即可。如果有同名的情况，用成员内部类对象名访问的就是内部类的成员
        // ，反之不写对象名或者写this访问的都是外部类的成员。
        System.out.println("innerClazz7.m1 = " + innerClazz7.m1);

        System.out.println("m1 = " + m1);
    }

    public static void test2() {
        // 在这里访问内部类成员。 一定要先创建内部类成员。
        // 'com.cskaoyan._06oop3._03inner._02member.OuterClazz7.this'
        // cannot be referenced from a static context
        // InnerClazz7 innerClazz7 = new InnerClazz7();
        // 想创建内部类对象，一定要先创建外部类对象。（）
        OuterClazz7 outerClazz7 = new OuterClazz7();
        InnerClazz7 innerClazz7 = outerClazz7.new InnerClazz7();

        String m11 = innerClazz7.m1;

        // System.out.println(m1);


    }

    class InnerClazz7 {
        private String privateStringName = "privateStringName";
        String defaultStringName = "defaultStringName";
        public String publicStringName = "publicStringName";

        public String m1 = "m1InInner";
        public String m2 = "m2InInner";
    }


}
