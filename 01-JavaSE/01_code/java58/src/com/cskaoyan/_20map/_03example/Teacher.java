package com.cskaoyan._20map._03example;

public class Teacher {
    int id;

    String name;

    int age;

    public int getId() {
        return id;
    }

    public Teacher setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Teacher setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Teacher setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
