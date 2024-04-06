package com.cskaoyan._21stream._01introduct;

import java.util.Objects;

public class Student {
    public enum Address {
        BJ, SH, WH, SZ
    }

    public Student(String name, int age, int height, Address address) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.address = address;
    }

    private String name;
    private int age;
    private int height;
    private Address address;


    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Student setHeight(int height) {
        this.height = height;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Student setAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return age == student.age && height == student.height && Objects.equals(name, student.name) && address == student.address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", address=" + address +
                '}';
    }
}
