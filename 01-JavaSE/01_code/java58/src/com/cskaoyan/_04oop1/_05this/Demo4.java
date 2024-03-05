package com.cskaoyan._04oop1._05this;

/**
 * this对成员变量进行赋值。
 *
 * @author Common-zhou
 * @since 2024-03-05 15:11
 */
public class Demo4 {

    public static void main(String[] args) {
        Car4 car4 = new Car4();

        car4.setName("BMW");


        System.out.println("car4.name = " + car4.name);
    }

}


class Car4 {
    public String name;
    public String color;

    // setName有什么作用？ 设置名字的方法。
    public void setName(String name) {
        // 想用传入的name。来设置成员变量的name。怎么写？
        // name = name;
        // this.name  左边代表当前对象的 name属性（成员变量。 ）
        // 右边 name。代表的是你传入的name。
        // this.name = name;  所以这句话的意思就是。用你传入的这个name。 设置给成员变量的name。
        this.name = name;
    }
}
