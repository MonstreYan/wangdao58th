package com.cskaoyan._04oop1._02define;

/**
 * 在类体中，我们可以定义两类东西。
 * 1. 成员变量: 描述对象的共有属性。 比如，年龄、身高、体重
 * 2. 成员方法: 描述对象的共有行为。 比如吃饭、睡觉、学习。
 * <p>
 * 如何定义成员变量？
 * 定义在类体中，方法外的变量，就称之为成员变量。
 * [修饰符列表] 数据类型 成员变量名;
 * public   int  age;
 * public  String name;
 * <p>
 * <p>
 * 成员变量，在整个类体中生效，在整个类中的成员方法中都可以访问它！
 *
 * @author Common-zhou
 * @since 2024-03-04 17:05
 */
public class Demo2 {

}

// 定义了一个类。 类的名字叫做 Student2.
//
class Student2 {
    // 定义在类体中，方法外的变量，就称之为成员变量。
    public int age;
    public String name;

    // 定义一个方法。 用来学习。
    // [访问权限修饰符] 返回值类型  方法名(形参列表){
    // 方法体
    // }
    public void study() {
        // 成员变量，在整个类体中生效，在整个类中的成员方法中都可以访问它！
        // 在成员方法中，可以访问成员变量。
        System.out.println(name + "study");
    }


}
