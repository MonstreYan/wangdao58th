package com.cskaoyan._21stream._04endstream;

import com.cskaoyan._21stream._01introduct.Student;
import com.cskaoyan._21stream._01introduct.StudentList;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Common-zhou
 * @since 2024-04-06 16:14
 */
public class Demo3Collect {
    @Test
    public void test1() {
        // collect。将流里面的数据，收集起来，放进合适的容器（指定的容器。 ）
        // Collectors.toList()
        // Collectors.toCollection()
        // Collectors.toSet()
        // Collectors.toMap()
    }


    @Test
    public void test2() {
        // 现在，想收集一下，所以身高高于 175的同学的姓名。

        List<Student> studentList = new StudentList().studentList;

        List<String> collect = studentList.stream().filter(student -> student.getHeight() > 175)
                .map(student -> student.getName()).collect(Collectors.toList());

        // class java.util.ArrayList
        System.out.println(collect);
        System.out.println(collect.getClass());

    }

    @Test
    public void test3() {
        List<Student> studentList = new StudentList().studentList;

        // toCollection: 允许你指定接的集合的类型。
        LinkedList<String> collect = studentList.stream().filter(student -> student.getHeight() > 175).map(student -> student.getName()).collect(Collectors.toCollection(() -> new LinkedList<>()));
    }


    @Test
    public void test4() {
        // Collectors.toSet()
        // 现在想知道，身高超过 175 的，都是来自哪些城市。

        List<Student> studentList = new StudentList().studentList;
        Set<Student.Address> collect = studentList.stream().filter(student -> student.getHeight() > 180).map(student -> student.getAddress()).collect(Collectors.toSet());

        System.out.println(collect);
        System.out.println(collect.getClass());


        List<Student.Address> collect1 = studentList.stream().filter(student -> student.getHeight() > 180).map(student -> student.getAddress()).distinct().collect(Collectors.toList());

        System.out.println(collect1);

    }


    @Test
    public void test5() {
        // 现在，想把所有同学，key是同学姓名，value是同学对象。

        List<Student> studentList = new StudentList().studentList;
        // toMap： 就是把原有流中的数据，变成Map。 但是对于Map来说，它不知道键怎么生成，值怎么生成。
        // 所以需要告诉它，key怎么生成，value怎么生成。
        // 流里面有Student。
        Map<String, Student> map = studentList.stream().collect(Collectors.toMap(student -> student.getName(), student -> student));

        System.out.println(map);
    }

    @Test
    public void test6() {
        List<Student> studentList = new StudentList().studentList;

        Map<String, Student> map = studentList.stream().collect(Collectors.toMap(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName();
            }
        }, new Function<Student, Student>() {
            @Override
            public Student apply(Student student) {
                return student;
            }
        }, new BinaryOperator<Student>() {
            @Override
            public Student apply(Student student, Student student2) {

                student.setHeight(student.getHeight() + student2.getHeight());

                return student;
            }
        }));
        System.out.println(map);


        // 流里面只有一个一个的数据。
        // toMap   ： key怎么生成； value怎么生成。
        // 三个参数，就是key重复了，这时候流框架不知道怎么处理，需要你告诉它。 怎么合并两个value。
    }
}
