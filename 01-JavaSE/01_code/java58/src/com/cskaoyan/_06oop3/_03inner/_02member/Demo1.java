package com.cskaoyan._06oop3._03inner._02member;

/**
 * 成员内部类是最普通的内部类，它定义在另一个类的成员位置， 可以看成该类的一个成员。
 * [访问权限修饰符] class OuterClazz{
 * // 在一个类内部定义另一个类。这个就叫做成员内部类
 * [访问权限修饰符] class InnerClazz{}
 * }
 * 访问权限修饰符。 四个都可以写。
 * 1. 外部类可以保护成员内部类，如果想要访问一个成员内部类。首先需要外部类权限，然后还需要成员内部类权限。
 * 2. 都定义成员内部类了，多数情况下，应该私有化它。
 *
 * @author Common-zhou
 * @since 2024-03-12 16:08
 */
public class Demo1 {

}

// class    ===   clazz
// 外部类
class OuterClazz1 {
    // [访问权限修饰符] class 内部类类名{}
    class InnerClazz1 {
    }

}
