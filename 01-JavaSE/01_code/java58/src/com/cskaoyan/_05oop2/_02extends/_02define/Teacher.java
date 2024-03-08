package com.cskaoyan._05oop2._02extends._02define;

public class Teacher extends Person {
    // Teacher继承了Person这个类。
    // Teacher是继承别人的。 所以称之为子类。
    // Person是被继承的，称之为父类。


    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void teach() {
        System.out.println(this.getName() + "正在上课");
    }
}

// 继承的语法
// [权限修饰符] class 类名 extends 已存在的类名{}
