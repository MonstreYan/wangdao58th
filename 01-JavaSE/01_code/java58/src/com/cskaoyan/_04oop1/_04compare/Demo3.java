package com.cskaoyan._04oop1._04compare;

/**
 * 局部变量和成员变量的区别。
 * 1. 有无默认初始化不同
 * 局部变量没有默认初始化。
 * 成员变量有默认初始化。   (byte/shrot/int/long  默认值是0)
 * 引用数据类型，默认值  null
 * char  默认值是一个  空
 *
 * <p>
 * 2. 作用范围
 * 1. 局部变量只在作用域的局部生效。
 * 2. 成员变量在整个类的成员方法中都可以使用，所以很多书籍也把成员变量称之为"全局变量"。
 * 注意，加static的方法不是成员方法，成员变量不能在其中使用（原因后面再讲）
 *
 * @author Common-zhou
 * @since 2024-03-05 14:36
 */
public class Demo3 {
    public static void main(String[] args) {
        test1();

        // 创建老师的时候，有没有给 name、age赋值
        Teacher3 teacher3 = new Teacher3();

        System.out.println("teacher3.name = " + teacher3.name);
        System.out.println("teacher3.age = " + teacher3.age);


        // 作用域不同。
        // System.out.println(flag);
        System.out.println("=============================");
        Teacher31 teacher31 = new Teacher31();

        teacher31.test1();

    }

    private static void test1() {
        // 什么叫做默认初始化。 我不赋值，系统自己给一个值它
        // 局部变量，没有默认初始化。 如果你不赋值。这里就不能使用。
        // Variable 'flag' might not have been initialized
        int flag;

        // System.out.println(flag);
    }
}


class Teacher3 {
    public String name;
    public int age;
}

class Teacher31 {
    public String name;
    public int age;


    public void test1() {
        // 这个是成员方法。 在所有的成员方法中，都可以访问成员变量
        System.out.println(name);
        System.out.println(age);
    }
}
