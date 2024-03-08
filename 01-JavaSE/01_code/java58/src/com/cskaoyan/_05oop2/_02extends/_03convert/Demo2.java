package com.cskaoyan._05oop2._02extends._03convert;


import com.cskaoyan._05oop2._02extends._02define.Person;
import com.cskaoyan._05oop2._02extends._02define.Teacher;

/**
 * @author Common-zhou
 * @since 2024-03-08 16:10
 */
public class Demo2 {
    public static void main(String[] args) {
        // 1.在正常情况下，创建谁的对象，就用谁的引用接收。
        // 创建Teacher。
        Teacher teacher = new Teacher();

        // 2.但是在具有父子类关系的两个类中，存在用父类引用接收子类对象的情况。
        // Teacher  和 Person 具有父子继承关系。
        Person person = new Teacher();

        // 3. 在这种情况下，子类对象被当成了父类对象去使用了。
        // 4. 即子类可以看成就是一个父类，也就是"is-a"关系。


        // 从数据类型的定义角度解释：
        // 1. 数据类型是 一组数据 + 基于数据的操作
        // 2. 引用数据类型是 成员变量的集合 + 成员方法的集合
        // 3. 子类通过继承父类，得到了父类的所有成员，从数据类型上来说，子类就覆盖了父类的成员，具有了父类的功能。
        // 4. 子类可以当做父类去使用，也就是子类"is-a"父类。


        // 父类能当子类用吗(父类"is-a"子类关系)？
        // - 显然不能，子类往往比父类功能要强大，父类不能当成子类使用

        // Cat   Animal
        // Cat 是一个 Animal。 也就是子类可以当做父类。
        // Animal是一个Cat.
        //

    }
}
