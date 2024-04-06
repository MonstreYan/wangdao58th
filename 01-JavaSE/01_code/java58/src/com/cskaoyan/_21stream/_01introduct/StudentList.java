package com.cskaoyan._21stream._01introduct;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentList的作用，就是为我们提供初始化数据的。
 *
 */
public class StudentList {
  public List<Student> studentList;

  public StudentList() {
    this.studentList = new ArrayList<>();

    studentList.add(new Student("aa", 18, 170, Student.Address.BJ));
    studentList.add(new Student("bb", 20, 163, Student.Address.SH));
    studentList.add(new Student("cc", 30, 182, Student.Address.WH));
    studentList.add(new Student("dd", 16, 190, Student.Address.BJ));
    studentList.add(new Student("ee", 15, 210, Student.Address.SH));
    studentList.add(new Student("ff", 17, 160, Student.Address.WH));
    studentList.add(new Student("gg", 18, 169, Student.Address.BJ));
    studentList.add(new Student("hh", 20, 173, Student.Address.WH));
    studentList.add(new Student("ii", 22, 192, Student.Address.SH));
    studentList.add(new Student("jj", 25, 172, Student.Address.SH));
    studentList.add(new Student("kk", 24, 188, Student.Address.BJ));
    // 重复元素 kk
    studentList.add(new Student("kk", 24, 188, Student.Address.BJ));
    studentList.add(new Student("ll", 17, 161, Student.Address.WH));
    studentList.add(new Student("mm", 18, 169, Student.Address.SH));
    studentList.add(new Student("nn", 20, 162, Student.Address.BJ));
    studentList.add(new Student("oo", 22, 166, Student.Address.SH));
    studentList.add(new Student("pp", 24, 176, Student.Address.WH));
    studentList.add(new Student("qq", 22, 173, Student.Address.BJ));
    // 重复元素 qq
    studentList.add(new Student("qq", 22, 173, Student.Address.BJ));
    studentList.add(new Student("rr", 24, 177, Student.Address.BJ));
    studentList.add(new Student("ss", 17, 169, Student.Address.SH));
    studentList.add(new Student("tt", 18, 170, Student.Address.SH));
    studentList.add(new Student("uu", 20, 171, Student.Address.WH));
    studentList.add(new Student("vv", 22, 172, Student.Address.WH));
    studentList.add(new Student("ww", 24, 181, Student.Address.BJ));
    studentList.add(new Student("xx", 18, 188, Student.Address.SH));
    studentList.add(new Student("yy", 20, 183, Student.Address.BJ));
    studentList.add(new Student("zz", 22, 191, Student.Address.WH));
  }
}
