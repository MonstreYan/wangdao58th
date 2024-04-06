package com.cskaoyan._21stream._01introduct;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Common-zhou
 * @since 2024-04-06 10:15
 */
public class Demo1 {

    @Test
    public void test1() {
        List<Student> studentList = new StudentList().studentList;

        System.out.println(studentList.size());

    }

    @Test
    public void test2() {
        // 我们要对这个学生列表进行处理:  得到来自北京同学, 并且高度最高的三个同学

        // 1.筛选北京的同学
        List<Student> studentList = new StudentList().studentList;

        List<Student> beijingStudentList = new ArrayList<>();

        for (Student student : studentList) {
            if (Student.Address.BJ.equals(student.getAddress())) {
                // 北京同学。
                beijingStudentList.add(student);
            }
        }

        System.out.println(beijingStudentList);

        // 2.排序。 对身高排，取前三
        beijingStudentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getHeight() - o2.getHeight();
            }
        });
        System.out.println(beijingStudentList);

        System.out.println("beijingStudentList.get(beijingStudentList.size() - 1) = " + beijingStudentList.get(beijingStudentList.size() - 1));
        System.out.println("beijingStudentList.get(beijingStudentList.size() - 2) = " + beijingStudentList.get(beijingStudentList.size() - 2));
        System.out.println("beijingStudentList.get(beijingStudentList.size() - 3) = " + beijingStudentList.get(beijingStudentList.size() - 3));
    }

    @Test
    public void test3UseStream() {
        // 流是一种处理数据的方式。 水流。
        List<Student> studentList = new StudentList().studentList;
        List<Student> collect = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress()))
                .sorted((o1, o2) -> o2.getHeight() - o1.getHeight())
                .limit(3).collect(Collectors.toList());

        System.out.println(collect);

        // 流，就是一种处理数据的方式，将数据模拟成水流。 水流在管道中流过的时候。可以针对性的处理，筛选、排序。处理好之后，数据就出来了。



    }
}
