package com.cskaoyan._04oop1._02define;

import java.math.BigDecimal;

/**
 * 1.想创建一个 床。 就是一个类。
 * 价格。 长、宽、 重量
 * 提供给别人睡觉。 需要传入一个参数。 人的名字
 *
 * @author Common-zhou
 * @since 2024-03-04 17:40
 */
public class Demo6 {
    public static void main(String[] args) {
        // 1.创建一张床。   这张床价格 2000.1  长200 宽180 重量200。

        // 类名 对象名 = new 类名()
        // Bed bed1 = new Bed();

        // 推荐先写右边。然后左边的自动生成。
        // ctrl + alt + v自动生成
        Bed bed = new Bed();

        // 设置属性进行。  在对这个对象里面的属性，进行赋值。
        bed.price = new BigDecimal(2000.1);
        bed.length = 200;
        bed.width = 180;
        bed.weight = 200;

        // 能不能获取属性？  ==> 能获取。 而且就是你刚刚设置进去的值。
        System.out.println("bed.length = " + bed.length);
        System.out.println("bed.width = " + bed.width);


        // 调用对象的方法， 怎么调用？
        // 对象名.方法名(参数)
        bed.providedSleep("景天");
    }
}

class Bed {
    // 价格： 在企业里面，要用什么类型。
    // float  double   不精确。
    // 不要用float、 double来存储科学数据、 价格。
    public BigDecimal price;

    // 长、宽、 重量
    public int length;
    public int width;
    public int weight;

    // 提供给别人睡觉。 需要传入一个参数。 人的名字
    // [权限修饰符] 返回值类型  方法名(形参){}
    public void providedSleep(String name) {
        // 180*200的床正在提供给zhangsan睡觉

        // souf  Java这些程序员。 更喜欢用拼接
        System.out.println(length + "*" + width + "的床正在提供给" + name + "睡觉");
    }


}
