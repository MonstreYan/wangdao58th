package com.cskaoyan._04oop1._02define;

/**
 * 练习，定义一个学生类，学生有姓名和年龄, 地址。有学习和吃饭两个方法。吃饭传入一个地址参数（eatAddress）。
 *
 * @author Common-zhou
 * @since 2024-03-04 17:13
 */
public class Demo3 {

}

class Student3 {
    // 学生有姓名和年龄, 地址
    // [权限修饰符] 数据类型 成员变量名;
    public String name;
    public int age;
    public String address;

    // 有学习和吃饭两个方法。吃饭传入一个地址参数（eatAddress）。
    // [权限修饰符] 返回值类型 方法名(形参列表){
    // 方法体
    // }
    public void study() {
        // 在成员方法里面，可以访问成员变量
        System.out.println(name + "正在学习");
    }

    public void eat(String eatAddress) {
        System.out.println(name + "正在" + eatAddress + "吃饭");
    }


}

