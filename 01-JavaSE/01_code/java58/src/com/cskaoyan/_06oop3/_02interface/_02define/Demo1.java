package com.cskaoyan._06oop3._02interface._02define;

/**
 * 语法格式：
 * [访问权限修饰符] interface 接口名{
 * // 方法的定义
 * }
 * <p>
 * 1.访问权限修饰符。 只能是 public或者 默认的
 * 2.接口的命名，和类保持一致。 使用大驼峰命名方式。 有些程序员，喜欢在接口名前加上一个  I 来表示，它是一个接口
 * 3.接口中可以定义抽象方法，和抽象类中定义抽象方法没有区别。(public abstract可省略, )
 * 因为在接口中，默认有这些修饰符
 * <p>
 * 4.接口是可以被一个类"继承"的，接口的"继承"，更准确、常见的叫法称之为接口的实现。
 * 当然它也不再使用extends关键字，而是使用 implements 关键字。
 * 一个普通类实现接口必须实现所有抽象方法。它的语法是：
 * class 类名 implements 接口名{}
 * <p>
 * 如果既想继承类。 也想实现接口。语法格式是这样的：
 * class 类名 extends 父类名 implements 接口名{}
 *
 * 5. 在接口的实现中，可以称呼接口为"父接口"，接口的实现类为"子类"，它们仍然是父子关系。当然多态现象仍然能够发生。
 *
 * Sparrow
 *
 * @author Common-zhou
 * @since 2024-03-12 10:18
 */
public class Demo1 {

}

// Class 'Play1' is public, should be declared in a file named 'Play1.java'
interface Play1 {
    // Modifier 'abstract' is redundant for interface methods
    // Modifier 'public' is redundant for interface members
    // public abstract void test1();
    void test1();
}

// 这个就完成了对一个接口的实现。
class Play1Impl implements Play1 {

    @Override
    public void test1() {
        System.out.println("Play1Impl test1 method");
    }
}

interface IPlay1 {
}
