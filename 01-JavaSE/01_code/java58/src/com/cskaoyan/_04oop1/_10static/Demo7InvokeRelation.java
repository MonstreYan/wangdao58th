package com.cskaoyan._04oop1._10static;

/**
 * 主要讲。 静态方法、非静态方法、 静态成员变量、 成员变量 之间的访问关系。
 * <p>
 * 1.静态方法。
 * 1） 能访问静态方法
 * 2） 不能访问成员方法。
 * 3） 能访问静态成员变量。
 * 4） 不能访问成员变量。
 * 静态能访问静态； 静态不能访问非静态
 * <p>
 * 2. 成员方法
 * 1） 全都能访问。 静态方法、成员方法、静态变量、成员变量。 都能访问
 *
 * @author Common-zhou
 * @since 2024-03-07 11:27
 */
public class Demo7InvokeRelation {

    public static String demo7TestStaticVariable = "hello demo7";
    public String demo7TestNotStaticVariable = "hello demo72";

    public static void main(String[] args) {
        // 静态方法

        // case1:访问静态成员变量
        System.out.println("demo7TestStaticVariable = " + demo7TestStaticVariable);
        // case2: 访问静态成员方法
        test1StaticMethod();

        // case3: 访问 成员变量  ==> 不允许访问
        // Non-static field 'demo7TestNotStaticVariable' cannot be referenced from a static context
        // System.out.println("demo7TestNotStaticVariable = " + demo7TestNotStaticVariable);

        // case4: 访问成员方法  ==》 不允许访问
        // Non-static method 'test2NotStaticMethod()' cannot be referenced from a static context
        // test2NotStaticMethod();

        // ===================================
        // 静态能访问静态； 静态不能访问非静态
        // 静态方法，能访问静态成员变量，能访问静态成员方法
        // 静态方法，不能访问成员变量，不能访问成员方法。
    }


    public static void test1StaticMethod() {
        System.out.println("test1StaticMethod" + demo7TestStaticVariable);
    }

    public void test2NotStaticMethod() {
        System.out.println("test2NotStaticMethod");
    }


}
