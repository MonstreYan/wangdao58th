package com.cskaoyan._06oop3._01abstract;

/**
 * 1.抽象方法，就是没有方法体的方法。 方法上加abstract 关键字
 * 2.抽象方法，必须在抽象类中。
 *
 * @author Common-zhou
 * @since 2024-03-11 17:21
 */
public class Demo1 {
    public static void main(String[] args) {
        // 抽象类不能创建对象，但抽象类可以继承，存在子类。并且抽象类作为父类，多态现象仍然存在。
        // 'Animal1' is abstract; cannot be instantiated
        // Animal1 animal1 = new Animal1();

        // 父类引用指向子类对象。
        Animal1 animal1 = new Dog1();
        animal1.shout();
        // 多态现象仍然存在： 编译看左边，运行看右边。
    }
}

// 普通类改成抽象类。
// 抽象方法，没有方法体。
abstract class Animal1 {
    // Abstract method in non-abstract class
    public abstract void shout();
}

// Class 'Dog1' must either be declared abstract or implement abstract method 'shout()' in 'Animal1'
//
class Dog1 extends Animal1 {
    @Override
    public void shout() {
        System.out.println("Dog1 shout");
    }
}
