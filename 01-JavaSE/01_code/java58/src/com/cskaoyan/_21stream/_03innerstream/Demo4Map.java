package com.cskaoyan._21stream._03innerstream;

import com.cskaoyan._21stream._01introduct.Student;
import com.cskaoyan._21stream._01introduct.StudentList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * map就是将流里面的一种类型，转换到另一种类型；或者不改变类型。
 *
 * @author Common-zhou
 * @since 2024-04-06 14:36
 */
public class Demo4Map {
    @Test
    public void test1() {
        // map。 比如，之前流里流的是人， 现在只想要这批人的年龄。
        List<Student> studentList = new StudentList().studentList;
        List<Integer> ageList = new ArrayList<>();
        for (Student student : studentList) {
            // System.out.println(student.getAge());
            ageList.add(student.getAge());
        }

        System.out.println(ageList);

        // 现在，一定要掌握一门手艺。
        // 把数据合理的存起来。
    }

    @Test
    public void test2() {
        List<Student> studentList = new StudentList().studentList;

        // map方法，必须要传入一个Function
        // Function里面有两个泛型。 <T, R> T是入参类型，R是返回参数类型
        // 方法内部的作用，就是流框架把一个一个的数据给你，你告诉流框架，怎么得到新的数据
        List<Integer> collect = studentList.stream().map(new Function<Student, Integer>() {
            @Override
            public Integer apply(Student student) {
                return student.getAge();
            }
        }).collect(Collectors.toList());

        System.out.println(collect);
    }


    @Test
    public void test3() {
        // map就是把一种类型，转换为另外一种类型。 或者不转换类型
        // 现在，我想看一下，学生里面有来自哪些地方的人？
        List<Student> studentList = new StudentList().studentList;
        List<Student.Address> collect = studentList.stream().map(new Function<Student, Student.Address>() {
            @Override
            public Student.Address apply(Student student) {
                return student.getAddress();
            }
        }).distinct().collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void test4() {
        // 现在，我对人群的年龄
        // 比如我想将一批人的年龄，转化为 青年（0-29），中青年（30-39），中年（40-49），中老年（50岁以上）。

        List<Integer> list = Arrays.asList(10, 29, 33, 35, 38, 42, 44, 59, 58, 51);
        List<String> collect = list.stream().map(new Function<Integer, String>() {
            @Override
            public String apply(Integer age) {
                if (age <= 29) {
                    return "青年";
                } else if (age <= 39) {
                    return "中青年";
                } else if (age <= 49) {
                    return "中年";
                } else {
                    return "中老年";
                }
            }
        }).collect(Collectors.toList());

        System.out.println(collect);
    }

    @Test
    public void test5() {
        // 现在，超过180的人，我认为是超人。 不用之前的Student来存储。
        // SuperPerson   name  String address;
        // 1.找超过180的人。
        // 2.把 180的人，转成SuperPerson这个类。

        List<Student> studentList = new StudentList().studentList;

        List<SuperPerson> collect = studentList.stream().filter(new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getHeight() > 180;
            }
        }).map(new Function<Student, SuperPerson>() {
            @Override
            public SuperPerson apply(Student student) {
                return new SuperPerson(student.getName(), student.getAge(), student.getAddress().name());
            }
        }).collect(Collectors.toList());

        System.out.println(collect);

    }


    @Test
    public void testSorted1() {
        // sorted 排序。
        List<Student> studentList = new StudentList().studentList;

        // 想找 武汉的。 按照身高排序。
        List<Student> collect = studentList.stream().filter(student -> Student.Address.WH.equals(student.getAddress())).sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getHeight() - o1.getHeight();
            }
        }).collect(Collectors.toList());

        System.out.println(collect);
    }
}

class SuperPerson {
    String name;
    int age;
    String address;

    public SuperPerson(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperPerson{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }
}
