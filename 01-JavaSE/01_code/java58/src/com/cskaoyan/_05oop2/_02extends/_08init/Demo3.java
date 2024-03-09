package com.cskaoyan._05oop2._02extends._08init;

/**
 * 在父子继承关系中。 它的步骤
 * 1.类加载。 （并且一定是先父类，后子类。 ）
 * 2.创建子类对象。
 * 2.1 子类区域中，有一块专门区域，用来存储父类的成员变量。 近似可以看做一个父类对象。用super关键字指向
 * 2.2 子类自身的成员变量，也会存储在子类对象中。
 * <p>
 * 成员变量赋值先父后子如何保证? 主要保证的策略是：
 * - 父类构造器优先于子类构造器执行
 * <p>
 * <p>
 * 在目前看来， 这个子类构造方法，并没有调用父类的构造方法。
 * 1.子类对象的隐式初始化： 在Java里面，如果子类没有显式调用父类的构造方法。 这里隐含了一句话。 ==》 super()  调用父类的构造方法。 隐式父类对象初始化
 * 2.子类对象的显式初始化: 在子类中，可以显式调用父类的构造方法。
 *
 * 最终，就一个目的。 在子类对象初始化的时候。 一定要先执行父类的构造方法。
 * 如果你手动调用了，这时候。就不会隐式调用。
 * 如果你没有手动调用，这时候会隐式调用。
 *
 * @author Common-zhou
 * @since 2024-03-09 10:12
 */
public class Demo3 {
}

class Father3 {
    String name = "fatherName";

    // public Father3() {
    // }

    public Father3(String name) {
        this.name = name;
    }
}


class Son3 extends Father3 {
    String sonName = "sonName";

    public Son3() {
        // 子类的构造方法
        // There is no default constructor available in 'com.cskaoyan._05oop2._02extends._08init.Father3'
        // 说明： 这里的父类的无参构造方法，肯定被调用了
        super("123");
    }
}
