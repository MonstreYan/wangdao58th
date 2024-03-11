package com.cskaoyan._06oop3._01abstract;

/**
 * 1.类名命名特点是什么?
 * 类名一定是大驼峰。
 * 抽象类仍然是一个类，它的命名仍然需要遵循大驼峰的命名规范。当然，它比较特殊，
 * 许多公司的开发规范中，会要求将抽象类命名为 AbstracXxx 或BaseXxx，用于表示该类是一个抽象类。
 * 这样命名，有什么好处：便于区分，读到名字就知道它可能是个抽象的。
 * <p>
 * 2.能用哪些修饰符？  --> 不能使用修饰符（final）
 * <p>
 * AbstractPeople  ：
 *
 * @author Common-zhou
 * @since 2024-03-11 17:33
 */
public class Demo2 {

}

abstract class AbstractPerson {
    public abstract void test1();
}
