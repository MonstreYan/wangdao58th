package com.cskaoyan._02method._02define;

/**
 * 方法完全可以没有结果，也就是没有返回值，但是方法必须要有返回值类型，用关键字void标记
 *
 * @author Common-zhou
 * @since 2024-03-01 16:13
 */
public class Demo6 {

    // 输入一个圆的半径，然后计算圆周长，计算圆面积，并且打印。 无返回值。
    // [权限修饰对] 返回值类型 方法的名字(形参列表){
    //  // 方法的具体逻辑、
    // }

    public static void calulateCirclereferenceAndArea(int radius) {
        double circlereference = 2 * 3.14 * radius;
        double circleArea = 3.14 * radius * radius;

        System.out.println("圆的周长是：" + circlereference);
        System.out.println("圆的面积是：" + circleArea);
        // Cannot return a value from a method with void result type
        // return 0;
    }

    public static void main(String[] args) {
        calulateCirclereferenceAndArea(10);
        calulateCirclereferenceAndArea(50);
    }


}
