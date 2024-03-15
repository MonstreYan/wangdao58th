package com.cskaoyan._08othercls._01wrapper;

import org.junit.Test;

/**
 * 拆装箱
 * 拆箱： 把引用数据类型，变成基本数据类型
 * 装箱： 把基本数据类型，变成引用数据类型。
 * 自动拆装箱。
 *
 * @author Common-zhou
 * @since 2024-03-15 17:03
 */
public class Demo3 {
    @Test
    public void testBoxAndUnBox() {
        // 装箱： 把基本数据类型，变成引用数据类型。
        // Java的自动装箱。
        Integer num1 = 10;

        // 拆箱： 把引用数据类型，变成基本数据类型
        int num2 = num1;
    }

    @Test
    public void testBox() {
        // 手动装箱： 把基本数据类型，变成引用数据类型、

        // 手动装箱。  Unnecessary boxing
        Integer num1 = Integer.valueOf(10);

        // 手动拆箱： 把引用数据类型，变成基本数据类型
        int i = num1.intValue();

        // 手动拆装箱可以操作。 但是必要性不大。
        // idea

    }


    /**
     * 包装数据类型，转换为String。
     * * 方式1： 使用toString()
     * * 方式2：使用字符串拼接
     * * 方式3： 使用String.valueOf()
     * <p>
     * 1965864578457 int.
     * 比如，想让你统计，这里面有多少个大于5的数。
     */
    @Test
    public void testToString() {

        Integer num = 10;

        // 方式1： 使用toString()
        // 现在，调用toString，直接拿到是10. 为啥？
        // Integer的底层。 重写了toString() 方法。
        String string = num.toString();
        System.out.println(string);

        // 方式2：使用字符串拼接
        String s = num + "";
        System.out.println(s);

        // 方式3： 使用String.valueOf()
        String s1 = String.valueOf(num);

        System.out.println(s1);
    }

    /**
     * 将String转换为包装类，以Integer举例。其余的类似
     * 方式1： parseInt()  parseXxx()
     * 方式2： Integer.valueOf()
     * 方式3： 使用Integer的构造方法
     */
    @Test
    public void testStringToWrapper() {
        String s = "123";
        String s1 = "123.45";

        // 方式1： Integer.parseInt()  parseXxx() Double.parseDouble()
        int num = Integer.parseInt(s);
        System.out.println(num);

        double v = Double.parseDouble(s1);
        System.out.println(v);

        // Long.parseLong()
        // Float.parseFloat()

        // 方式2： Integer.valueOf()
        Integer num2 = Integer.valueOf(s);
        System.out.println(num2);

        // 方式3： 使用Integer的构造方法
        Integer i = new Integer(s);
    }
}
