package com.cskaoyan._05oop2._02extends._01introduct;

/**
 * 分别定义一个表示人和学生的类：
 * 1. 人类：有姓名属性，以及吃饭这个行为
 * 2. 教师类：有姓名，教师号两个属性，同时有吃饭，教学(上课)两种行为
 * 3. 学生类：有姓名，学号两个属性，同时有吃饭，学习两种行为
 *
 * 有什么问题？  重复代码非常多。
 * 如果想复用代码，需要使用Java中的继承。
 * @author Common-zhou
 * @since 2024-03-08 15:51
 */
public class Demo1 {

}

// 如果不用继承。怎么做。
class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("吃饭中");
    }
}

// 教师类：有姓名，教师号两个属性，同时有吃饭，教学(上课)两种行为
class Teacher {
    private String name;

    private String teacherId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void eat() {
        System.out.println("吃饭中");
    }

    public void teach() {
        System.out.println("上课中");
    }
}


// 学生类：有姓名，学号两个属性，同时有吃饭，学习两种行为
class Student {
    private String name;
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("吃饭中");
    }

    public void study() {
        System.out.println("学习中");
    }
}
