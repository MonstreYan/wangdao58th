package com.cskaoyan._21stream._03innerstream;

import com.cskaoyan._21stream._01introduct.Student;
import com.cskaoyan._21stream._01introduct.StudentList;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Common-zhou
 * @since 2024-04-06 11:39
 */
public class Demo3 {
    @Test
    public void test1() {
        // distinct 就是去重。

        List<Student> studentList = new StudentList().studentList;

        // distinct的底层是LinkedHashSet。 所以需要完成去重，就得hashCode和equals方法。
        long count = studentList.stream().distinct().count();

        System.out.println(count);

    }


    @Test
    public void test2() {
        // limit 方法用于获取指定数量(最大)的流。


        List<Student> studentList = new StudentList().studentList;
        // 找出北京的同学，年龄在22岁之上的。 截取3个。
        List<Student> collect = studentList.stream().filter(student -> {
            return Student.Address.BJ.equals(student.getAddress());
        }).filter(student -> student.getAge() > 22).limit(3).collect(Collectors.toList());

        // limit就是截取数据。 截取的是前几个。
        // 如果流里面有4个数据，limit(3) 最终3个数据 。
        // 如果流里面有4个数据 limit(10) 最终4个数据。
        System.out.println(collect);

        List<Student> collect1 = studentList.stream().filter(student -> {
            return Student.Address.BJ.equals(student.getAddress());
        }).filter(student -> student.getAge() > 22).limit(10).collect(Collectors.toList());
        System.out.println(collect1);
    }

    @Test
    public void test3() {
        List<Student> studentList = new StudentList().studentList;

        // 如果里面一个数据都没了，会怎么办  limit(5)
        List<Student> collect = studentList.stream().filter(student -> {
            return Student.Address.BJ.equals(student.getAddress());
        }).filter(student -> student.getAge() > 24).limit(5).collect(Collectors.toList());

        System.out.println(collect);
    }


    @Test
    public void test4() {
        List<Student> studentList = new StudentList().studentList;

        // skip 跳过前n个元素。
        List<Student> collect = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())).collect(Collectors.toList());

        System.out.println(collect);


        List<Student> collect1 = studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress())).skip(3).collect(Collectors.toList());

        System.out.println(collect1);
        // 跳过前n个元素。 skip(n) 跳过前n个元素。
    }


    @Test
    public void test5() {
        // 如果不会流，能不能写代码。
        // 找出北京的同学，年龄在22岁之上的。 截取3个。

        List<Student> studentList = new StudentList().studentList;

        // 学流的目的，不是替代之前的操作。
        // 而是防止，你的同事写这种代码，你看不懂。
    }
}
