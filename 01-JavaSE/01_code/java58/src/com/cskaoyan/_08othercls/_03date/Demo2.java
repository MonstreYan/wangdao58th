package com.cskaoyan._08othercls._03date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Common-zhou
 * @since 2024-03-16 11:37
 */
public class Demo2 {
    @Test
    public void test1() {
        // SimpleDateFormat 就是负责，帮你将Date这个对象，格式化出来。

        // Date这个表示日期和时间。
        // 但是它的默认toString， 太丑了。

        // 比如，我有个当前时间。 最后我想让它输出好看。  2024/03/16 11:38:02
        // Sat Mar 16 11:25:12 CST 2024

        // 这个就要用到SimpleDateFormat

    }

    @Test
    public void testConstructor1() {
        // 构造方法中，需要传入一个Pattern
        // yyyy/MM/dd HH:mm:ss   2024/03/16 11:43:02

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    }

    @Test
    public void testMethod1() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM/dd HH:mm:ss");

        // SimpleDateFormat 就两个功能。
        // 一个是将 Date转换为你想要的字符串格式。
        // date  --->   2024/03/16 11:43:02

        String formatted = simpleDateFormat.format(new Date());
        System.out.println(formatted);

        // 第二个就是将一个字符串，转换为Date
        // "2024-01-02 11:33:02"  -->  Date .
        Date parse = simpleDateFormat.parse("2024-01/16 11:32:03");

        System.out.println(parse);

    }

    @Test
    public void testMethod2() {
        // 关于 SimpleDateFormat  和  Date 的关系，不要搞混了

        // Date是用来，表示时间的。
        // SimpleDateFormat 是用来帮你转换的。只是一个桥梁，帮你把 String  和 Date

        // Date   --->    String
        // String   --->   Date
    }

    @Test
    public void testLocalDate() {
        // 我也想用LocalDate  来表示。  2021-03-15
        // 比如，现在我想用LocalDate这个类，表示  2021-03-15这个时间，怎么写。
        LocalDate date = LocalDate.of(2022, 3, 15);
        // 打印表示的日期
        System.out.println("指定日期: " + date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // 使用指定格式解析字符串为LocalDate对象
        LocalDate date2 = LocalDate.parse("2021/03/15", formatter);
        System.out.println(date2);

    }
}
