package com.cskaoyan._08othercls._03date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Common-zhou
 * @since 2024-03-16 11:06
 */
public class Demo1 {
    @Test
    public void test1Constructor() {
        // // 该构造函数使用当前日期和时间来创建对象
        //     Date()
        // // 使用一个时间戳来创建对应时间的日期对象
        //     Date(long date)

        // 空构造方法： 表示，创建一个Date对象。表示当前时间
        Date date = new Date();
        System.out.println(date);

        // 使用一个时间戳来创建对应时间的日期对象
        Date date1 = new Date(0);

        // 08:00:00
        System.out.println(date1);
    }

    @Test
    public void testConstructor2() {
        Date date = new Date();

        // public Date() {
        //     this(System.currentTimeMillis());
        // }
        // public Date(long date) {
        //         fastTime = date;
        //     }
        // Date的底层，就是存储的ms数，到1970.1.1 0:0:0

        Date date1 = new Date(0);
    }

    @Test
    public void testCurrentTimeMills() {
        // currentTimeMillis 当前的ms。 到1970.1.1
        long l = System.currentTimeMillis();
        System.out.println(l);

        Date date = new Date(l);

        System.out.println(date);

        // System.currentTimeMillis();就是当前的ms数。 这个东西比较有用，一般用来计时。
    }


    @Test
    public void testCurrentTimeMills2() throws InterruptedException {
        // currentTimeMillis  一般怎么用
        // 一般用在Java中，对程序运行时间进行记录。

        long startTime = System.currentTimeMillis();
        test1();
        long endTime = System.currentTimeMillis();

        System.out.println("运行时间：" + (endTime - startTime));

    }

    private void test1() throws InterruptedException {
        System.out.println("===============");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("*************");
    }

    @Test
    public void test2ToString() {
        // 以下看一下成员方法。 首先我们看toString

        // 代表当前时间
        Date date = new Date();

        // Sat Mar 16 11:19:58 CST 2024

        // 默认是出现什么： toString方法。
        // 说明，Date重写了  toString。
        System.out.println(date);

        // Sat Mar 16 11:19:58 CST 2024
        // 星期 月份 天数 hh：mm：ss 时区缩写 年份
        // 中国的时区缩写是CST（China Standard Time）

        // 默认输出方式。
    }

    @Test
    public void test4SetTimeAndGetTime() {
        Date date = new Date();

        System.out.println(System.currentTimeMillis());
        System.out.println("date.getTime() = " + date.getTime());
        // getTime 拿出来的也是ms数。

        date.setTime(0);
        System.out.println(date);


        Date date1 = new Date(1710559512861L);

        System.out.println(date1);

    }

    @Test
    public void testLocalDate() {
        // 我还不知道。它能不能表示，时分秒。
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);

        // 这个能表示年月日 时分秒
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDateTime);

        // 2024-03-16T11:30:17.533141500

        // 现在，我想让LocalDateTime这个对象，格式化好看一些。 输出年月日 时分秒。格式如下
        // 2024/03/16 11*30*17

    }

    @Test
    public void testFormat(){

        // 获取当前日期和时间
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 定义日期时间格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH*mm*ss");

        // 格式化日期和时间
        String formattedDateTime = currentDateTime.format(formatter);

        // 打印格式化后的日期和时间
        System.out.println("格式化后的日期和时间: " + formattedDateTime);
    }
}
