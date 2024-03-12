package com.cskaoyan._06oop3._02interface._07link;

/**
 * @author Common-zhou
 * @since 2024-03-12 15:46
 */
public class Demo2 {
    public static void main(String[] args) {
        Student2 student2 = new Student2();

        // 这个就是链式编程： 返回值是一个引用。我们可以节点往后点。
        student2.setAddress("hubei").setName("zhansgan").setAge(20).setPhone("110");

        System.out.println("student2.getAge() = " + student2.getAge());
        System.out.println("student2.getName() = " + student2.getName());
        System.out.println("student2.getAddress() = " + student2.getAddress());
    }
}


class Student2 {
    String name;
    int age;
    String address;
    String phone;


    public String getName() {
        return name;
    }

    public Student2 setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student2 setAge(int age) {
        this.age = age;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Student2 setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Student2 setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
