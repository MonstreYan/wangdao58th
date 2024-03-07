package com.cskaoyan._04oop1._10static;

/**
 * 2. 成员方法
 * 1） 全都能访问。 静态方法、成员方法、静态变量、成员变量。 都能访问
 *
 * 成员方法，全部都能访问。
 *
 * @author Common-zhou
 * @since 2024-03-07 11:39
 */
public class Demo8InvokeRelation {


    public static void main(String[] args) {
        // 静态不能调用非静态。 new对象才可以。
        Demo8InvokeRelation demo8InvokeRelation = new Demo8InvokeRelation();

        demo8InvokeRelation.test1NotStaticMethod();
    }

    public static String demo8StaticVariable = "demo8StaticVariable 111";
    public String demo8NonStaticVariable = "demo8NonStaticVariable 222";

    public void test1NotStaticMethod() {
        // 这是一个成员方法
        // case1: 可以访问静态成员变量
        System.out.println("demo8StaticVariable = " + demo8StaticVariable);
        // case2: 可以访问成员变量
        System.out.println("demo8NonStaticVariable = " + demo8NonStaticVariable);

        // case3：可以访问静态成员方法
        test1StaticMethod();

        // case4: 可以访问成员方法
        test2NotStaticMethod();
        // 递归。 不要写成递归了。会出现死循环。
    }

    public static void test1StaticMethod() {
        System.out.println("test1StaticMethod");
    }

    public void test2NotStaticMethod() {
        System.out.println("test2NotStaticMethod");
    }


}
