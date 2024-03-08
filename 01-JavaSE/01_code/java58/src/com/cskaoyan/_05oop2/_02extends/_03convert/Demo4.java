package com.cskaoyan._05oop2._02extends._03convert;

import com.cskaoyan._05oop2._02extends._02define.Person;
import com.cskaoyan._05oop2._02extends._02define.Student;

/**
 * @author Common-zhou
 * @since 2024-03-08 16:19
 */
public class Demo4 {
    public static void main(String[] args) {
        // 子类 is-a 父类。

        // 子类是一个父类。   因为，子类有父类中所有的成员变量，成员方法。
        // 是成立的。

        // 可以用父类引用去接收子类。

        Student student = new Student();
        Person person = new Person();

        // 把student这个引用，转换成 Person这个类型了
        // 转换的到底是什么东西？
        // 是引用，还是是把底层的对象，转换为了父类对象
        person = student;
    }
}
