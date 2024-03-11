package com.cskaoyan._05oop2._03poly;

/**
 * 多个子类同时重写了父类中的一个方法，
 * 并出现父类引用指向不同子类对象，并且用对象名点调用同名方法时，方法的调用结果就体现出多态的特点。
 * <p>
 * 对于同名方法的访问。
 * 编译看左边，运行看右边
 *
 * @author Common-zhou
 * @since 2024-03-11 16:06
 */
public class Demo3 {

    public static void main(String[] args) {
        // 对于方法来说。
        // 编译看左边，运行看右边。
        // 这个引用的实质，是什么东西？ 狗
        Animal3 animal3 = new Dog3();

        // 编译的时候，能点出来的都是左边有的方法。
        // 但是点不出来。现在看起来它就是一个Animal。 所以点不出来Dog特有的方法
        animal3.eat();
        animal3.shout();
        // 运行看右边。 就是它实际是什么类型，调用的时候，就是调用的它的具体方法
        // 你重写了，就按照你重写的来； 没重写，就按照继承过来的来。

        Dog3 dog3 = (Dog3) animal3;
        dog3.watchHome();

    }
}

class Animal3 {
    public void shout() {
        System.out.println("animal shout");
    }

    public void eat() {
        System.out.println("animal eat");
    }
}

class Dog3 extends Animal3 {

    @Override
    public void shout() {
        System.out.println("狗汪汪叫。。。");
    }

    public void watchHome() {
        // 看门
        System.out.println("狗狗看门");
    }
}

class Cat3 extends Animal3 {

    @Override
    public void shout() {
        System.out.println("猫喵喵喵。。。");
    }

    public void playWithOther() {
        System.out.println("猫陪人玩");
    }
}


