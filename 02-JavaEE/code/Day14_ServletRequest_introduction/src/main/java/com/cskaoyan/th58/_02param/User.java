package com.cskaoyan.th58._02param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/4/27 11:49
 * @Version 1.0
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class User {

    private String username;

    private String password;

    private String gender;

    private String[] course;

    private String province;


    public String getUsername() {
        return username;
    }

    //只是修改了一下set方法的名称，那么后续便无法进行封装了
    public void setName(String username) {
        this.username = username;
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

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", course=" + Arrays.toString(course) +
                ", province='" + province + '\'' +
                '}';
    }
}
