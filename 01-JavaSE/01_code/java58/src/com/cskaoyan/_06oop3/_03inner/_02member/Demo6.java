package com.cskaoyan._06oop3._03inner._02member;

/**
 * 1.前提： 成员内部类对象，一定依赖谁存在？  一定依赖外部类对象存在。
 * <p>
 * ====》 所以，在你创建内部类对象的时候。（外部类对象一定要存在。 ）
 * <p>
 * 2.成员内部类，访问外部类成员的特点
 * 没有任何访问权限，可以随便用。  内部类的成员方法，可以随意访问外部类的成员
 * <p>
 * 如果在一些极端情况下。（同名） ， 按照就近原则来访问。
 * 如果同名了，想访问外面一些特定的变量。
 * 1) 直接写变量名： 拿到的是局部变量
 * 2）用this.变量名： 拿到的是内部类成员变量
 * 3）用  外部类名.this.变量名： 拿到的就是外部类成员变量
 *
 * @author Common-zhou
 * @since 2024-03-12 17:11
 */
public class Demo6 {

}


class OuterClazz6 {
    private String name;
    int age;
    protected String address = "hubei";

    String test1String = "test1OuterString";
    String test2String = "test2OuterString";
    String test3String = "test3OuterString";


    class InnerClazz6 {
        String test1String = "test1InnerString";
        String test3String = "test3InnerString";


        public void test1() {
            System.out.println("innerClazz6 test1 method");
        }

        public void test2() {
            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("address = " + address);
        }

        public void test3() {
            String test3String = "test3MethodValue";

            // 访问变量的时候，一定按照就近原则来访问。
            System.out.println("test3String = " + test3String);
            System.out.println("test1String = " + test1String);
            System.out.println("test2String = " + test2String);
        }
    }

    public static void main(String[] args) {
        // 在这个位置去创建内部类对象。
        //  所以，在你创建内部类对象的时候。（外部类对象一定要存在。 ）
        // 在这个位置，外部类对象有没有？   没有
        OuterClazz6 outerClazz6 = new OuterClazz6();

        InnerClazz6 innerClazz6 = outerClazz6.new InnerClazz6();

        innerClazz6.test1();

        System.out.println("==============================");

        innerClazz6.test3();
    }

    public void test2() {
        // 在这里去创建内部类对象。 外部类对象，目前有没有。   this

        InnerClazz6 innerClazz6 = new InnerClazz6();
    }

}
