package com.cskaoyan._04oop1._05this;

/**
 * this关键字的作用
 * 1. 在成员方法中，用this引用去访问类中成员变量和调用类中成员方法。
 * 由于this本身就是隐含的，所以一般情况下，可以省略this，直接访问类中成员。
 * 2. 特殊情况下，当成员方法中的局部变量和成员变量同名时，可以用 "this."访问 来表示访问同名成员变量，
 * 来和同名局部变量做区分。这种情况，this是不能省略的。
 * 3. 在成员方法中只要使用 "this."访问 一个变量，那么该变量一定是成员变量。
 * 在代码比较复杂的情况下，可以显著增加代码可读性, 可以使用this.成员变量对成员变量进行赋值--->set方法
 *
 * @author Common-zhou
 * @since 2024-03-05 15:05
 */
public class Demo3 {
    public static void main(String[] args) {
        Car3 car3 = new Car3();
        car3.name = "BYD";
        car3.color = "白色";

        car3.test1();

    }
}


class Car3 {
    public String name;
    public String color;

    public void test1() {
        // 可以使用this去访问成员变量或者成员方法。
        // 因为this是隐含的，所以很多时候，可以省略不写。
        // System.out.println(this.name);
        // System.out.println(this.color);

        System.out.println(name);
        System.out.println(color);
        // 如果碰到就近原则的时候。 一定要写。
    }


    public void test2() {
        // 可以使用this来访问成员变量，来访问成员方法。
        // 当局部位置，有和成员变量相同名的变量的时候，一定要使用this
        String name = "BMW";
        System.out.println(name);


    }
}
