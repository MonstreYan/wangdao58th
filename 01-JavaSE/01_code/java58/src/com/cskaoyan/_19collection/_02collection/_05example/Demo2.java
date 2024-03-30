package com.cskaoyan._19collection._02collection._05example;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Date。
 * 往前找两年。
 * 往前找一个月、 找俩月。
 * JDK内部提供了大量的工具类。不要自己去写。
 *
 * @author Common-zhou
 * @since 2024-03-29 17:00
 */
public class Demo2 {
    @Test
    public void test1() throws ParseException {
        // 假设这是你要检查的Date对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Date dateToCheck = simpleDateFormat.parse("2022-03-29 16:59:02");
        Date dateToCheck = simpleDateFormat.parse("2022-03-29 17:59:02");

        // 转换为LocalDateTime进行比较
        LocalDateTime dateTimeToCheck = dateToCheck.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime twoYearsAgo = LocalDateTime.now().minusYears(2);

        // 检查日期是否在两年之内
        if (dateTimeToCheck.isAfter(twoYearsAgo)) {
            System.out.println("日期在当前时间的两年之内");
        } else {
            System.out.println("日期不在当前时间的两年之内");
        }
    }


    @Test
    public void test2() throws ParseException {
        // 假设这是你要检查的Date对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateToCheck = simpleDateFormat.parse("2022-03-29 16:59:02");
        // Date dateToCheck = simpleDateFormat.parse("2022-03-29 17:59:02");

        // 获取当前日期并计算两年前的日期
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);
        calendar.add(Calendar.HOUR, 2);

        Date twoYearsAgo = calendar.getTime();

        // 检查日期是否在两年之内
        if (dateToCheck.after(twoYearsAgo)) {
            System.out.println("日期在当前时间的两年之内");
        } else {
            System.out.println("日期不在当前时间的两年之内");
        }
    }
}
