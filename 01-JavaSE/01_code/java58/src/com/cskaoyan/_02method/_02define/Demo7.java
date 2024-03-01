package com.cskaoyan._02method._02define;

/**
 * 实参的自动类型转换: 方法在调用时，如果填入的实参的数据类型，可以自动类型转换成形参的数据类型，
 * 那么即便数据类型不一致，语法上仍然允许该数据类型的变量作为实参。
 * 反之强制类型转换不行。方法的返回值和它的返回值类型也存在这种特点！
 * (如果一个方法需要传入一个long类型数据，那我传入一个int值可以吗？如果传入double值可以吗?)
 *
 * @author Common-zhou
 * @since 2024-03-01 16:20
 */
public class Demo7 {
    public static void main(String[] args) {
        // 10就是int。这时候没有问题。
        test1(10);

        short s1 = 20;
        // 实参可以自动转换为形参。 一定有一个前提：一定是小转大。
        // 一定是自动类型转换。如果是从大范围转换为小范围，这时候会报错。
        test1(s1);

        double d1 = 1.2;
        // test1((int)d1);

    }

    public static int test1(int num1) {
        System.out.println(num1);

        return num1;
    }
}
