package com.cskaoyan._19collection._02collection._05example;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 2.想找出 2022-2023年下单的所有订单信息
 * <p>
 * 2023-01-01 - 2023-12-31
 * 需要确定这个问题。 是否包括2023年、
 *
 * 分辨一下，信息的正确性。
 *
 * @author Common-zhou
 * @since 2024-03-30 10:00
 */
public class Homework1 {

    @Test
    public void test1() throws ParseException {
        // 2022-2023
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date checkedDate = dateFormat.parse("2022-01-02 01:08:01");

        Date beginTime = dateFormat.parse("2024-01-01 00:00:00");
        Date endTime = dateFormat.parse("2023-12-31 23:59:59");
        System.out.println("beginTime.before(checkedDate) = " + beginTime.before(checkedDate));
        System.out.println("endTime.after(checkedDate) = " + endTime.after(checkedDate));
    }


    @Test
    public void test2() {
        // 2年内入学的时间。

        // 我们怎么找出两年内的时间。
        // 有两种理解：
        // 1.以当前时间，往前找两年。   Date   -   new Date
        // 2.以9。1为界限。
        // 在做这种模糊的需求的时候，一定要确认清楚， 到底是哪种理解是正确。


        // 有时候API不会，去搜一搜。

        Date currentDate = new Date();

        // 这行代码，代表的是一年，取决于谁？ 产品。
        // System.currentTimeMillis() - 3600 * 1000 * 24 * 365;

        // GPT: 清楚明了的表达自己的想法。
        // 谷歌、百度： 关键字。

        // Java   Date    往前找两年
    }

    @Test
    public void test3(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        //现在日期
        String now = format.format(new Date());
        System.out.println("现在日期  ："+now);

        //过去七天
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, - 7);
        Date d = calendar.getTime();
        String day = format.format(d);
        System.out.println("过去七天  ："+day);

        //过去一月
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date m = calendar.getTime();
        String mon = format.format(m);
        System.out.println("过去一个月："+mon);

        //过去三个月
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -3);
        Date m3 = calendar.getTime();
        String mon3 = format.format(m3);
        System.out.println("过去三个月："+mon3);

        //过去一年
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1);
        Date y = calendar.getTime();
        String year = format.format(y);
        System.out.println("过去一年  ："+year);

    }
}

class Order {
    //订单号，订单金额，订单时间，订单状态(未付款、已付款、已发货、已评价)，订单更新时间

    String id;

    double price;

    Date orderTime;

    String status;

    Date updateTime;

    public Order(String id, double price, Date orderTime, String status, Date updateTime) {
        this.id = id;
        this.price = price;
        this.orderTime = orderTime;
        this.status = status;
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", price=" + price + ", orderTime=" + orderTime + ", status='" + status + '\'' + ", updateTime=" + updateTime + '}';
    }
}
