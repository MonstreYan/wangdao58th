package com.cskaoyan._06oop3._01abstract;

/**
 * 使用
 * 抽象类的使用，我们主要探讨，它的子类特点。
 * 抽象类的子类可以有两种情况：
 * <p>
 * 1. 子类是普通类，普通类继承抽象类，必须实现所有的抽象方法。
 * 2. 子类是抽象类，抽象子类不需要实现抽象方法，抽象子类可以自由选择实现（或实现或不实现）。
 * <p>
 * 注：抽象类还可以继承一个普通类, 实际上如果一个抽象类, 它没有直接父类, 那它就直接继承Object
 * <p>
 * <p>
 * ctrl + i  : implement  实现方法。
 *
 * @author Common-zhou
 * @since 2024-03-11 17:44
 */
public class Demo4 {

}

// 抽象类中，普通类中可以定义的东西，它都能定义。
// 只是加了个抽象方法。
abstract class AbstractPerson4 {
    public abstract void test1();

    public abstract void test2();

    public void test3() {
        System.out.println("test3");
    }
}

// 子类是普通类，普通类继承抽象类，必须实现所有的抽象方法。
class Person41 extends AbstractPerson4 {

    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }
}

// 子类是抽象类，抽象子类不需要实现抽象方法，抽象子类可以自由选择实现（或实现或不实现）。
// 有的时候，往下走，有一些方法就可以实现了。
abstract class AbstractPerson4Son extends AbstractPerson4 {

    @Override
    public void test1() {

    }
}
