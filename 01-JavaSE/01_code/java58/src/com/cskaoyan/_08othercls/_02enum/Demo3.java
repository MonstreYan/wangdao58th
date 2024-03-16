package com.cskaoyan._08othercls._02enum;

/**
 * @author Common-zhou
 * @since 2024-03-16 10:28
 */
public class Demo3 {
    public static void main(String[] args) {
        // Weekday3.MONDAY;
        // 枚举其实就是Java官方提供的。帮助我们定义一些 非常固定的类型。
        // 比如，你的程序里有 周一、周二、周日
        // 普通用户、VIP/SVIP/SSVIP  定义非常死，不会突然从其他地方出现一个。       SSSSSSSVIP
        // 货物的状态： 待发货、已发货、运输中、派件中、已签收、已拒收

        System.out.println("Weekday3.MONDAY = " + Weekday3.MONDAY);
    }
}


enum Weekday3 {
    // 这个就是枚举体

    // 属性可以有。
    // 构造方法可以有
    // 常量。

    // 枚举体的定义，实际上就是定义一个一个的常量，用"逗号,"隔开。枚举体中的单个常量的名字应该全部大写。并且放在枚举体的最上面
    // public static final WeekDay2 MONDAY = new WeekDay2("周一", 1);

    MONDAY("周一", 1), TUESDAY("周二", 2), WEDNESDAY("周三", 3);
    String name;
    int id;

    Weekday3(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

