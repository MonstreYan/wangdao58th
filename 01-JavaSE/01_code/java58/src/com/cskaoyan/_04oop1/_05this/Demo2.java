package com.cskaoyan._04oop1._05this;

/**
 * @author Common-zhou
 * @since 2024-03-05 14:57
 */
public class Demo2 {
    public static void main(String[] args) {
        Car2 car2 = new Car2();
        car2.color = "白色";
        car2.speed = 50;

        // 对于这个car2  来说。什么叫做当前对象。  就是它自己。
        // this就是指的当前对象。
        // 对于car2来说，它的this，就是它自己。
        // 对于car21来说，它的this，就是指的car21
        car2.run();

        System.out.println(car2);

        Car2 car21 = new Car2();
        car21.run();

        System.out.println(car21);


    }
}

class Car2 {
    public String color;
    public int speed;

    public void run() {
        // 在每一个成员方法中，都隐含了一个传参。  this。
        // this就是当前对象。
        // 为什么我们可以在成员方法中，访问成员变量。就是因为this。
        // System.out.println(color);

        System.out.println("run方法内部， 打印this:" + this);
    }
}
