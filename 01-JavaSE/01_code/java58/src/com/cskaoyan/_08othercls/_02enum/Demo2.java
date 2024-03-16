package com.cskaoyan._08othercls._02enum;

import org.junit.Test;

/**
 * 枚举类： 就是在整个JVM中，只有这么几个对象，多的没有。
 * <p>
 * WeekDay2  ：   周一、 7
 * 这个是我们自己实现的枚举
 *
 * @author Common-zhou
 * @since 2024-03-15 17:58
 */
public class Demo2 {
    @Test
    public void test1() {
        // WeekDay2(java.lang.String, int)' has private access in 'com.cskaoyan._08othercls._02enum.WeekDay2'
        // WeekDay2 weekDay2 = new WeekDay2("zhouyi", 1);
    }
}

class WeekDay2 {

    public static final WeekDay2 MONDAY = new WeekDay2("周一", 1);
    public static final WeekDay2 DAY_2 = new WeekDay2("周二", 2);
    public static final WeekDay2 DAY_3 = new WeekDay2("周三", 3);
    String name;
    int id;

    private WeekDay2(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "WeekDay{" + "name='" + name + '\'' + ", id=" + id + '}';
    }
}
