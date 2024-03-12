package com.cskaoyan._06oop3._03inner._02member;

/**
 * 成员内部类的访问特点。
 * - 成员内部类可以看成外部类的一个成员
 * - 类中的成员变量,必须依赖于类的对象而存在, 那么成员内部类的对象,也必须依赖于外部类对象而存在
 * 也就是说,要想得到成员内部类对象,必须在外部类对象的基础上创建,成员内部类对象不能单独创建,
 * 成员内部类依赖于外部类,反过来,没有依赖关系
 * <p>
 * 内部类，外部类。 内部类和外部类，之间的这些成员怎么访问，有什么特点。
 *
 * @author Common-zhou
 * @since 2024-03-12 16:24
 */
public class Demo4 {


}

class OuterClazz4 {

    String outerName = "outerName";

    class InnerClazz4 {
        String innerName = "123";
    }


}
