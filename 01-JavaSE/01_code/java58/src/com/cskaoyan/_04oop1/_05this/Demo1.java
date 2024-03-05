package com.cskaoyan._04oop1._05this;

/**
 * 创建一个汽车类，有颜色（color）和速度（speed）两个属性，行为是可以跑（run）。
 * 实现：
 * 1. 在run成员方法中访问速度和颜色两个属性，调用该方法查看结果。
 * 2. 在run成员方法的形参列表中，添加一个局部变量speed，不修改方法体，调用该方法查看结果。
 * 思考：
 * 1. 两次方法调用的结果一样吗？为什么？
 * 2. 如果我想在2中得到1的访问结果，怎么办呢？
 * <p>
 * leetcode: 能让你掌握一种能力，将文字转换为代码的能力。
 *
 * @author Common-zhou
 * @since 2024-03-05 14:50
 */
public class Demo1 {
    public static void main(String[] args) {
        Car car = new Car();

        car.color = "白色";
        car.speed = 100;

        car.run(110);

        // 就近原则。
        // 如果我还是想访问， 成员变量的 speed。 怎么办

    }
}

// 创建一个汽车类，有颜色（color）和速度（speed）两个属性，行为是可以跑（run）。
class Car {
    public String color;
    public int speed;

    // 1. 在run成员方法中访问速度和颜色两个属性，调用该方法查看结果。
    // public void run() {
    //     System.out.println(color + "颜色的车，正以" + speed + "km/h的速度在跑");
    // }

    // 2. 在run成员方法的形参列表中，添加一个局部变量speed，不修改方法体，调用该方法查看结果。
    public void run(int speed) {
        // System.out.println(color + "颜色的车，正以" + speed + "km/h的速度在跑");
        System.out.println(color + "颜色的车，正以" + this.speed + "km/h的速度在跑");
    }

}
