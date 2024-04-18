package com.cskaoyan.jdbc.bean;

import java.util.Date;

public class Student {

    private Integer id;

    private String name;

    private Integer gender;

    private Date entryDate;

    private Integer mid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Student(Integer id, String name, Integer gender, Date entryDate, Integer mid) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.entryDate = entryDate;
        this.mid = mid;
    }

    public Student() {}
}
