package com.cskaoyan._04oop1._06constructor;

/**
 * 构造方法，也是一个方法。 但是是一个比较特殊的方法。
 * 语法结构：
 * [访问权限修饰符] 类名(形参列表){
 * // 构造方法体
 * }
 * <p>
 * [访问权限修饰符] 返回值类型 方法名(形参列表)
 * <p>
 * 1.访问权限修饰符， 先写public
 * 2.构造方法，比较特殊， 没有返回值
 * 3.构造方法的方法名，直接写类名。
 * 4.其他的东西，与普通方法基本一致
 *
 * @author Common-zhou
 * @since 2024-03-05 15:26
 */
public class Demo2 {

}

class Teacher2 {
    // 课程和年龄，地址三个属性
    public String course;
    public int age;
    public String address;

    public Teacher2(/*形参列表*/){
        // 这里面就是方法体。 这个就是构造方法。
    }

    public void teach() {
        // 上课。  打印  多少岁的老师，上 ** 课
        System.out.println(age + "岁的老师，教" + course + "这个课");
    }

}
