package com.cskaoyan._05oop2._02extends._02define;

/**
 * 分别定义一个表示人和学生的类：
 * 1. 人类：有姓名属性，以及吃饭这个行为
 * 2. 教师类：有姓名，教师号两个属性，同时有吃饭，教学(上课)两种行为
 * 3. 学生类：有姓名，学号两个属性，同时有吃饭，学习两种行为
 * <p>
 * 1）  // Teacher继承了Person这个类。
 * // Teacher是继承别人的。 所以称之为子类。
 * // Person是被继承的，称之为父类。
 * 2）子类会获取父类的所有成员变量和成员方法。
 * 3） 子类可以在父类的基础上进行扩展，所以往往子类的功能更强。
 *
 * @author Common-zhou
 * @since 2024-03-08 15:58
 */
public class Demo1 {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("景天");
        teacher.setTeacherId("001");

        teacher.teach();
        teacher.eat();

        System.out.println("========================");
        Student student = new Student();
        student.setName("陈健");
        student.setStudentId("007");
        student.eat();
        student.study();

    }
}

