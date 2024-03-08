package com.cskaoyan._05oop2._02extends._03convert;

import com.cskaoyan._05oop2._02extends._02define.Person;
import com.cskaoyan._05oop2._02extends._02define.Student;

/**
 * @author Common-zhou
 * @since 2024-03-08 16:15
 */
public class Demo3 {
    public static void main(String[] args) {
        // 基本数据类型，可以发生数据类型转换。 引用数据类型，也可以发生数据类型转换，
        // 注意： 发生的前提。 一定是要有继承关系，才能发生类型转换。
        Student student = new Student();

        Person person = new Person();
        // 在这个过程中，其实发生了类型转换。 一定要注意。 一定是有继承关系，才能发生类型。
        person = student;

        System.out.println("=====================================");

        Demo3 demo3 = new Demo3();
        // demo3 = student;


    }
}
