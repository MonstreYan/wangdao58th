package com.cskaoyan._21stream._04endstream;

import com.cskaoyan._21stream._01introduct.Student;
import com.cskaoyan._21stream._01introduct.StudentList;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Common-zhou
 * @since 2024-04-06 15:05
 */
public class Demo1Match {
    @Test
    public void testAnyMatch() {
        // 是否有任意一个匹配。

        // 想找，是否北京有任意一个年龄在24以上的？

        List<Student> studentList = new StudentList().studentList;
        boolean anyMatch = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())).anyMatch(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getAge() > 23;
            }
        });


        List<Student> collect = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())).filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getAge() > 23;
            }
        }).collect(Collectors.toList());

        System.out.println(collect);

        System.out.println(anyMatch);
    }

    @Test
    public void test2() {
        // 不用流，现在想实现这个功能，怎么做？
        // 想找，是否北京有任意一个年龄在24以上的？
        List<Student> studentList = new StudentList().studentList;

        boolean flag = false;

        for (Student student : studentList) {
            if (Student.Address.BJ.equals(student.getAddress()) && student.getAge() > 24) {
                // System.out.println(student);
                flag = true;
            }
        }

        System.out.println(flag);
    }


    @Test
    public void test3() {
        // 现在，想看北京的同学，是否身高全部超过 >= 170

        List<Student> studentList = new StudentList().studentList;
        boolean flag = true;

        for (Student student : studentList) {
            if (Student.Address.BJ.equals(student.getAddress()) && student.getHeight() < 170) {
                flag = false;
            }
        }
        System.out.println(flag);
    }


    @Test
    public void test4() {
        List<Student> studentList = new StudentList().studentList;

        boolean b = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())).allMatch(student -> student.getHeight() >= 170);

        System.out.println(b);

    }


    @Test
    public void test5() {
        // 大家今后写方法的时候，不要写反义词。方法名
        // isEmpty : 是否为空
        // isNotEmpty: 是否不为空。

        // isNotEmpty: false
        // 如果方法名，取的反转，非常绕。
    }
}
