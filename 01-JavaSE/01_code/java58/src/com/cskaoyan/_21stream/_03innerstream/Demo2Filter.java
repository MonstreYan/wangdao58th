package com.cskaoyan._21stream._03innerstream;

import com.cskaoyan._21stream._01introduct.Student;
import com.cskaoyan._21stream._01introduct.StudentList;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 对元素进行过滤。比如想要某个地区的学生，比如想要年龄大于20的学生。
 *
 * @author Common-zhou
 * @since 2024-04-06 11:12
 */
public class Demo2Filter {
    @Test
    public void test1() {
        List<Student> studentList = new StudentList().studentList;

        // boolean test(T t);

        // 现在，流里面流的是 Student
        // Predict 就是你告诉流框架， 保留哪些数据。不保留哪些数据
        // 入参其实就是流里面的，一个一个的数据； 返回的boolean就是是否留下这个数据。
        List<Student> collect = studentList.stream().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                if (Student.Address.SH.equals(student.getAddress())) {
                    return true;
                }
                return false;
            }
        }).collect(Collectors.toList());

        System.out.println(collect);

    }

    @Test
    public void test2() {
        List<Student> studentList = new StudentList().studentList;

        List<Student> collect = studentList.stream().filter(student -> {
            // 'if' statement can be simplified
            // if (Student.Address.SH.equals(student.getAddress())) {
            //     return true;
            // }
            // return false;
            return Student.Address.SH.equals(student.getAddress());
        }).collect(Collectors.toList());

        System.out.println(collect);

    }

    @Test
    public void test3() {
        // 比如想要某个地区的学生，比如想要年龄大于20的学生。

        List<Student> studentList = new StudentList().studentList;
        // 1.现在，想筛选 北京的同学； 年龄在20岁及以上的
        List<Student> collect = studentList.stream()
                .filter(student -> Student.Address.BJ.equals(student.getAddress()) && student.getAge() >= 20)
                .collect(Collectors.toList());

        System.out.println(collect);

        // 有没有其他的写法？
        List<Student> collect1 = studentList.stream()
                // 所有的学生都能从这个位置通过
                .filter(student -> Student.Address.BJ.equals(student.getAddress()))
                // 只有北京的同学能通过
                .filter(student -> student.getAge() >= 20)
                // 只有北京的同学能通过，>=20的同学能出来
                .collect(Collectors.toList());

        System.out.println(collect1);
    }


    @Test
    public void test4() {
        List<Student> studentList = new StudentList().studentList;

        // 效率没有区别。 但是可读性有区别。
        // 1.年龄大于20且身高大于180
        // 2.北京的同学
        // 3.上海的同学，年龄小于24
        List<Student> collect = studentList.stream()
                .filter(student -> (student.getAge() > 20 && student.getHeight() > 180) ||
                        (Student.Address.BJ.equals(student.getAddress())) ||
                        (Student.Address.SH.equals(student.getAddress()) && student.getAge() < 24)
                ).collect(Collectors.toList());

        studentList.stream().filter(student -> (student.getAge() > 20 && student.getHeight() > 180))
                .filter(student -> Student.Address.BJ.equals(student.getAddress()))
                .filter(student -> (Student.Address.SH.equals(student.getAddress()) && student.getAge() < 24));


        // 连续的filter。 是且的意思。
    }


    @Test
    public void test5() {
        List<Student> studentList = new StudentList().studentList;

        // 效率没有区别。 但是可读性有区别。
        // 1.年龄大于20且身高大于180
        // 2.北京的同学
        // 3.上海的同学，年龄小于24
        List<Student> collect = studentList.stream()
                .filter(student -> (student.getAge() > 20 && student.getHeight() > 180) ||
                        (Student.Address.BJ.equals(student.getAddress())) ||
                        (Student.Address.SH.equals(student.getAddress()) && student.getAge() < 24)
                ).collect(Collectors.toList());

        studentList.stream().filter(((Predicate<Student>) student -> false)
                .or(((Predicate<Student>) student -> false)
                        .or(student -> false)));


    }

    @Test
    public void test6() {
        // filter就是筛选数据
    }
}
