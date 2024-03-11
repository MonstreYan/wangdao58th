package com.cskaoyan._05oop2._03poly;

/**
 * 多态： 从字面意义上理解，同一个事物，在不同的时刻/情况表现出不同的状态，就可以称之为多态。
 * 总结来说，Java中的多态指的是，同一个父类引用指向不同子类对象时，调用同名成员方法，
 * 根据指向实际对象的不同，得到的行为也会随之不不同。
 * <p>
 * 定义一个父类Phone, 3个子类HuaweiPhone, XiaoMiPhone, Iphone去模拟多态场景.
 *
 * @author Common-zhou
 * @since 2024-03-11 15:48
 */
public class Demo1 {
    public static void main(String[] args) {
        // Java中的多态指的是，同一个父类引用指向不同子类对象时，调用同名成员方法，
        // 根据指向实际对象的不同，得到的行为也会随之不不同。

        // 编译看左边，运行看右边。 ===》 对方法

        // Phone phone = new Phone();
        // Phone phone = new HuaweiPhone();
        Phone phone = new XiaomiPhone();
        // Phone phone = new IPhone();

        phone.call();
        phone.playGame();


    }

}

class Phone {
    public void call() {
        System.out.println("使用手机打电话");
    }

    public void playGame() {
        System.out.println("使用手机玩游戏");
    }
}


// 华为手机。
// 方法重写：
class HuaweiPhone extends Phone {
    @Override
    public void call() {
        System.out.println("使用华为卫星通讯打电话，信号嘎嘎好");
    }

    @Override
    public void playGame() {
        System.out.println("使用华为玩游戏，信号不错");
    }
}


class XiaomiPhone extends Phone {
    @Override
    public void call() {
        System.out.println("小米手机打电话。。。");
    }

    @Override
    public void playGame() {
        System.out.println("小米，打游戏烫手");
    }
}

class IPhone extends Phone {
    @Override
    public void call() {
        System.out.println("iphone打电话，信号不好");
    }

    @Override
    public void playGame() {
        System.out.println("iphone打游戏，信号不好");
    }
}
