package com.cskaoyan._08othercls._02enum;

import org.junit.Test;

/**
 * 定义一个表示星期的类WeekDay, 定义2个属性
 * String name: 表示是周几
 * int  id: 表示编号(1-7)
 * 创建并打印相应的对象
 *
 * 现在，我想让我的系统里面，只能有周一-周日。 其他的不允许有。 有啥方法？
 *
 * @author Common-zhou
 * @since 2024-03-15 17:54
 */
public class Demo1 {
    @Test
    public void test1() {
        // 定义了一个类，表示星期。 一周有   周一-周日
        WeekDay day1 = new WeekDay("周一", 1);
        WeekDay day2 = new WeekDay("周二", 2);
        WeekDay day3 = new WeekDay("周三", 3);
        WeekDay day4 = new WeekDay("周四", 4);
        WeekDay day5 = new WeekDay("周五", 5);
        WeekDay day6 = new WeekDay("周六", 6);
        WeekDay day7 = new WeekDay("周日", 7);

        // 创建出来了这样一些对象，用来表示周一-周日。 但是现在，
        WeekDay day8 = new WeekDay("周八", 8);


    }
}

class WeekDay {
    String name;
    int id;

    public WeekDay(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "WeekDay{" + "name='" + name + '\'' + ", id=" + id + '}';
    }
}
