package com.cskaoyan._18generic.d03;

import org.junit.Test;

/**
 * 用接口。实现一个共同的接口。然后车库类就存放这个接口。
 *
 * @author Common-zhou
 * @since 2024-03-27 10:12
 */
public class Demo3 {

    @Test
    public void test1() {
        // 使用Holder2来装AutoCar。

        Holder2 holder2 = new Holder2(new AutoCar());
        Car car = holder2.get();
        // 编译看左边，运行看右边。
        car.run();

        Holder2 holder21 = new Holder2(new Truck());
        Car car1 = holder21.get();
        car1.run();
    }

    @Test
    public void test2() {
        // 问题1： 不能调用子类特有的方法。
        // 如果要调用子类特有的方法，就需要强转。

        Holder2 holder2 = new Holder2(new AutoCar());
        Car car = holder2.get();
        car.run();

        AutoCar autoCar = (AutoCar) car;
        autoCar.openSkyLight();

        // 问题2： 有一些代码我们没有办法改。
        // 比如， String 我们也要存起来。
        // String
        // Holder2 holder21 = new Holder2(new String("1111"));
    }

}
