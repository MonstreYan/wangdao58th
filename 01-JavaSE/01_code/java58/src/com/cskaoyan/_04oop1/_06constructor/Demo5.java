package com.cskaoyan._04oop1._06constructor;

/**
 * @author Common-zhou
 * @since 2024-03-05 16:04
 */
public class Demo5 {

    public static void main(String[] args) {
        // 创建一个小猫。   白色， 名字叫做：喵
        Cat5 cat5 = new Cat5("白色", "喵");

        // 检验一下，属性是否设置进去了。
        cat5.shout();


    }

}


class Cat5 {
    // 有颜色、名字、体重  ==》 属性、成员变量
    private String color;
    private String name;
    // 假设存储的是体重的 g数
    private int weight;


    // 构造方法。
    // 想写两种构造方法。  color、name
    public Cat5(String color, String name) {
        // 构造方法，最主要的作用。就是完成对属性的值的设置。
        // 将传入的 color。 存放到 当前对象的color属性上。
        this.color = color;
        this.name = name;
    }
    // color、name、weight

    // [权限修饰符] 类名(形参列表){}

    public Cat5(String color, String name, int weight) {
        this.color = color;
        this.name = name;
        this.weight = weight;
    }


    // 会叫。  叫出它的名字，颜色，体重。
    public void shout() {
        System.out.println("小猫在叫,名字是" + name + "，颜色是" + color + ", 体重是" + weight + "g");

    }


}
