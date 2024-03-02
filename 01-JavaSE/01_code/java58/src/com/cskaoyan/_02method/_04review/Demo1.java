package com.cskaoyan._02method._04review;

import java.util.Scanner;

/**
 * 1.什么是方法？
 * 就是特定功能的代码块。 计算圆的面积， 计算圆的周长。
 * <p>
 * 方法的定义：
 * [权限修饰符] 返回值类型 方法名(形参列表){
 * 方法体
 * }
 *
 * 2.什么是方法的重载。
 * 方法名相同，形参列表不同。  数目不同 或者 类型不同。  或者顺序不同。
 * 描述问题时候，要清楚。
 * 首先要描述一下背景。   再去描述问题。
 *
 * 回答面试题的时候也是这样。
 *
 *  什么叫做方法的重载。 就是在方法名相同的时候，形参列表有所不同，这个称为方法的重载。
 *  形参列表不同，分为以下情况。  1.形参的数目不同。 2.形参的类型不同。3.形参的数目相同，类型相同，但是顺序不同。
 * @author Common-zhou
 * @since 2024-03-02 09:32
 */
public class Demo1 {
    public static void main(String[] args) {
        // 方法可以重复调用。
        // 而不用每一次都去复制代码。
        inputRectangleLengthAndWidthAndCalculateAreaAndPerimeterAndPrint();
        System.out.println("================");
        inputRectangleLengthAndWidthAndCalculateAreaAndPerimeterAndPrint();
        System.out.println("================");
    }


    // 假设，这个方法，专门用于从键盘上录入一个矩形的长和宽。然后计算矩形的面积，计算矩形的周长。 并且用 * 打印这个矩形。
    // 3*4
    // ****
    // ****
    // ****
    public static void inputRectangleLengthAndWidthAndCalculateAreaAndPerimeterAndPrint() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入矩形的长：");
        int length = scanner.nextInt();

        // ctrl + shift + 上
        System.out.println("请输入矩形的宽：");
        int width = scanner.nextInt();

        // 变量名小驼峰。  方法名小驼峰
        // 类名 大驼峰。
        int area = length * width;
        int perimeter = 2 * (length + width);

        System.out.println("矩形的面积是：" + area);
        System.out.println("矩形的周长是：" + perimeter);

        // 并且用 * 打印这个矩形。
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }


}
