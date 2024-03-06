package com.cskaoyan._04oop1._08example;

/**
 * 为啥需要用类，来组织数据？
 * 方便管理？  如果每一个数据都分散管理，非常混乱。
 * 比如，飞机有非常多零件，如果全部用单个变量标识。这时候，不知道哪个是919的。 哪个是737的。
 * 但是现在使用了类，对象之后。 这时候，就可以只有一个变量。
 * AirPlane airPlane919 = new AirPlane("919", "");
 * airPlane919.机翼   ==> 一定是919的。 所以方便了管理数据
 * airPlane737.机翼
 *
 * @author Common-zhou
 * @since 2024-03-06 11:13
 */
public class Demo2 {
    public static void main(String[] args) {
        // 举例。比如你现在在做一个学生管理系统。
        // 学生可以有  id，name， age，address, phone

        // 类在这里，是什么东西？

        // 假设，学生管理系统里面。 有3个人。
        // 1  zhangsan 18  hubei  112   ==》 对象。
        // 2  lisi 18  hubei  112
        // 3  wangwu 18  hubei  112
        // 在这个案例里面，对象是什么东西？


    }
}

class Student2 {
    // stuId   studentId
    public int id;
    public String name;
    public int age;
    public String address;
    public String phone;

    public void showAge() {
        System.out.println(name + "--->" + age);
    }
}
