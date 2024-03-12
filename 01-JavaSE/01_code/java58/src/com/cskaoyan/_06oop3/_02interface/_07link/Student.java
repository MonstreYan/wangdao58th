package com.cskaoyan._06oop3._02interface._07link;

class Student {
    public Student getStudent() {
        return new Student();
    }

    public Teacher getTeacher() {
        return new Teacher();
    }
}

class Teacher {
    public void show() {
        System.out.println("秀一波~~~");
    }
}
