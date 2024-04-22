package com.cskaoyan.th58;

public class Student {

    private String name;

    private String password;

    private String gender;

    private Integer age;

    public Student(String name, String password, String gender, Integer age) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
