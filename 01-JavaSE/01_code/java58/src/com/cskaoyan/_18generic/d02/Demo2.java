package com.cskaoyan._18generic.d02;

import org.junit.Test;

/**
 * 使用车库1 ，将小汽车、卡车全部装进去。
 *
 * @author Common-zhou
 * @since 2024-03-27 10:00
 */
public class Demo2 {
    @Test
    public void test1() {

        // holder1里面装的 是一个小汽车
        Holder1 holder1 = new Holder1(new AutoCar());

        // 父类引用指向子类对象。
        Object o = holder1.get();

        // 编译看左边，运行看右边
        // 不能直接用 AutoCar的run方法。 因为Object是个父类，看不到这个方法。
        // o.run();

        AutoCar autoCar = (AutoCar) o;

        autoCar.run();

    }

    @Test
    public void testTruck() {
        Holder1 holder1 = new Holder1(new Truck());
        Object o = holder1.get();

        Truck truck = (Truck) o;
        truck.run();
    }

    @Test
    public void test3() {
        // Holder1使用Object类型来接收。 可以处理所有类，AutoCar、Truck、F1、摩托车、自行车
        // 有没有什么缺点？
        // 不能访问子类特有的方法，必须得强转才能用。
        // ======= 强转就有强转报错问题。
        Holder1 holder1 = new Holder1(new Truck());

        Object o = holder1.get();
        AutoCar autoCar = (AutoCar) o;

        autoCar.run();
    }

    @Test
    public void test4() {

    }
}
