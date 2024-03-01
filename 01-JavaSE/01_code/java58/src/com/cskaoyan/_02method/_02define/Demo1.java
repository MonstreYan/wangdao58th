package com.cskaoyan._02method._02define;

/**
 * [修饰符列表]  :   可有可无。
 * <p>
 * [修饰符列表] 返回值类型 方法名(形式参数列表){
 * // 方法体
 * }
 * 1.修饰符列表：修饰符列表不是必须的，可以为空不写，现在默认为public static（具体含义面向对象讲）
 * 2.返回值类型：方法可能会有结果，这个结果就是返回值，返回值的数据类型称之为返回值类型
 * 2.1. 返回值类型可以是基本数据类型，也可以是引用数据类型（例如String）
 * - 此时表示方法拥有返回值，必须显式的指出该返回值，否则编译报错
 * - 在方法体中用return关键字指示返回值，格式为return + 返回值
 * - return后的返回值的数据类型，要和方法声明中的返回值类型保持一致（或者兼容）
 * - 方法执行到return语句时，表示方法执行完毕。
 * 2.2. 方法可以没有结果，也就是没有返回值，但是方法必须要有返回值类型，
 * 用关键字void标记。使用void标记的方法，没有返回值，自然也无需指出返回值
 * <p>
 * 3.方法名：给方法起个名字，调用方法时用的，方法名的命名需要遵守规范
 * - 必须是合法的标识符
 * - 方法名最好见名知意
 * - 小驼峰命名法（getMaxValue  calculateCircleArea）
 * <p>
 * 4. 形式参数列表：方法在实现功能时，有时需要传入数据。方法在定义时就应该告诉方法的调用者应该传入什么数据，这就是形式参数列表，简称形参列表
 * - 形参可以是基本数据类型变量，也可以是引用数据类型变量
 * - 形参的个数不受限，多个形参之间用逗号隔开
 * - 形参的作用域仅在方法内部，它们都是局部变量
 * - 形参中起关键决定性作用的是形参的数据类型，形参名只是一个标识符，不会影响方法调用
 * - 调用方法时传入的具体数据参数称之为实际参数，简称实参
 * - 方法调用时，实参和形参的数据类型要一一对应，并且保持一致（或者兼容）
 * 5. 方法体：方法体包含具体的语句，定义该方法的功能，由大括号包裹起来。
 * <p>
 * <p>
 * 驼峰：  getBeijingStudentCount。 单词和单词之间，首字母大写，用来区分不同的单词。
 * 小驼峰： 第一个单词首字母小写。  变量名、方法名
 * 大驼峰： 第一个单词首字母大写。   类名、 接口名
 *
 * @author Common-zhou
 * @since 2024-03-01 14:58
 */
public class Demo1 {

    // 定义了一个方法。 int代表返回值，代表返回值类型是int。
    // 方法的名字。
    public static int test1(int a) {
        // 在这里，能不能用a。
        System.out.println(a);

        // Missing return statement
        // 在方法中，怎么写返回值？
        return 1;
    }

    // 比如，现在要进行求和。
    // [修饰符列表] 返回值类型 方法名(形式参数列表)
    public static int sum(int num1, int num2) {

        int sum = num1 + num2;

        // System.out.println(sum);

        return sum;
    }

    // 比如，现在让你来计算一个圆形的周长。
    // 计算圆周长   半径
    public static double calculateCircumference(int radius) {
        return 2 * 3.14 * radius;
    }

    public static void main(String[] args) {
        // 如何调用一个方法？

        // 直接用 方法名(传入参数) 就可以调用一个方法.
        // ctrl + p
        int sum = sum(10, 20);
        System.out.println(sum);

        int sum1 = sum(30, 60);
        System.out.println(sum1);


        // 2 * 3.14 * 10
        double circumference = calculateCircumference(10);

        System.out.println(circumference);

    }

}
