package com.cskaoyan._04oop1._10static;

/**
 * @author Common-zhou
 * @since 2024-03-07 11:23
 */
public class Demo6Method2 {
    public static void main(String[] args) {
        // 1. 一个类中，静态方法无法直接调用非静态的方法和属性，也不能使用this，super关键字（super后面会讲）,静态的方法只能访问静态的
        // 2. 经典错误：Non-static field/method xxx cannot be referenced from a static context
        // 3. 原因：静态方法调用的时候，有可能没有对象，没有对象普通成员就无法访问。
        // 4. 普通成员方法当中，既可以访问静态成员的, 也可以访问非静态成员。普通成员方法访问任意的
        // 5. 访问静态成员变量的时候，使用类名.变量名的形式访问，以示区别，增加代码可读性

        test1StaticMethod();

        // Non-static method 'test2NotStaticMethod()' cannot be referenced from a static context
        // 非静态的方法。 不能在静态方法中调用。
        // test2NotStaticMethod();
    }

    public static void test1StaticMethod() {
        System.out.println("test1StaticMethod");
    }

    public void test2NotStaticMethod() {
        System.out.println("test2NotStaticMethod");
    }

}
