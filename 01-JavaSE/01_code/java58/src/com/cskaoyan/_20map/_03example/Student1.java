package com.cskaoyan._20map._03example;

public class Student1 {
    int id;
    String name;
    int age;
    int teacherId;


    public int getId() {
        return id;
    }

    public Student1 setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student1 setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student1 setAge(int age) {
        this.age = age;
        return this;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public Student1 setTeacherId(int teacherId) {
        this.teacherId = teacherId;
        return this;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", teacherId=" + teacherId +
                '}';
    }
}

