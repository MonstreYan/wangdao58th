package com.cskaoyan._01basic._05scanner;

import java.util.Scanner;

/**
 * @author Common-zhou
 * @since 2024-03-01 09:48
 */
public class Demo4 {
    public static void main(String[] args) {
        // ==================注意：
        // 如果要从键盘录入多种数据类型。 这里不要使用多种录入方法
        // nextInt  nextLine  nextDouble  ==>
        // 统一使用nextLine。 然后拿到字符串之后，再进行强转
        // String 转成 int :  Integer.parseInt()
        // String 转成double :  Double.parseDouble()

        // 12   zhangsan   1.2

        Scanner scanner = new Scanner(System.in);

        // 错误的写法
        // int num = scanner.nextInt();
        // String s = scanner.nextLine();
        // double v = scanner.nextDouble();
        // System.out.println(num);
        // System.out.println(s);
        // System.out.println(v);

        // 正确的写法
        // 统一使用nextLine进行接收。 最后再进行转换
        System.out.println("请输入一个int类型的数字：");
        String numString = scanner.nextLine();
        System.out.println("请输入一个String字符串：");
        String string = scanner.nextLine();
        System.out.println("请输入一个double类型的数字：");
        String doubleString = scanner.nextLine();

        // String  --->  int
        // Integer.parseInt()
        // 在括号里面。点  ctrl + p  就是查看输入的参数类型
        int num = Integer.parseInt(numString);
        System.out.println("得到的int值是：" + num);

        System.out.println("得到的String是：" + string);

        double doubleValue = Double.parseDouble(doubleString);
        System.out.println("得到的double是：" + doubleValue);

        // 如果在输入的时候。 出现了以下报错。 注意检查输入是否有空格或者其他的
        // Exception in thread "main" java.lang.NumberFormatException: For input string: "10 "
    }
}
