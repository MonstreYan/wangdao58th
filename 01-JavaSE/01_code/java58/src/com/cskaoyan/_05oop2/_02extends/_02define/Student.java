package com.cskaoyan._05oop2._02extends._02define;

public class Student extends Person {
    // Student继承了Person。 Student称之为子类。 Person称之为父类。
    // 继承可以获取所有的成员变量，所有的成员方法。
    // 子类可以在父类的基础上，进行修改或新增，所以子类往往更强大
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void study() {
        System.out.println(this.getName() + "正在学习");
    }
}
