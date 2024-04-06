package com.cskaoyan._21stream._04endstream;

import com.cskaoyan._21stream._01introduct.Student;
import com.cskaoyan._21stream._01introduct.StudentList;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author Common-zhou
 * @since 2024-04-06 15:18
 */
public class Demo2Find {

    @Test
    public void testFindAny() {
        // 找到任意一个。
        // findAny

        // 想找身高180及以上的任意一个同学。
        List<Student> studentList = new StudentList().studentList;

        Optional<Student> optional = studentList.stream().filter(student -> student.getHeight() >= 180).findAny();

        // optional其实是一个返回的结果。 它用来表示，结果是否存在，如果结果存在，会包在Optional里面

        // get方法，就是从这里面拿数据
        // isPresent() 就是这里面是否包含数据
        System.out.println("optional.get() = " + optional.get());

        boolean present = optional.isPresent();
        System.out.println(present);

        optional.ifPresent(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });
    }

    @Test
    public void test2() {
        // Optional的作用。
        // optional其实是一个返回的结果。 它用来表示，结果是否存在，如果结果存在，会包在Optional里面
        List<Student> studentList = new StudentList().studentList;

        Optional<Student> optional = studentList.stream().filter(student -> student.getHeight() >= 180).filter(student -> Student.Address.WH.equals(student.getAddress())).filter(student -> student.getAge() < 18).findAny();

        // null
        // 如果没有数据，为什么不直接给null。
        //   Student student

        System.out.println("optional.isPresent() = " + optional.isPresent());

        // 推荐这么用。
        if (optional.isPresent()) {
            Student student = optional.get();
            System.out.println(student);
        }

        // 有数据，就进去。 没数据就不进去。
        optional.ifPresent(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println("====consumer" + student);
            }
        });
    }


    @Test
    public void test3() {
        // findAny 就是任意找一个，默认是第一个
        // findFirst 找第一个。
        // 它们有什么区别。 在多线程的情况有区别。
        List<Student> studentList = new StudentList().studentList;

        // 想找北京的同学。 任意一个、第一个

        Optional<Student> optional =
                studentList.parallelStream().filter(student -> Student.Address.BJ.equals(student.getAddress())).findAny();
        if (optional.isPresent()) {
            System.out.println("findAny: optional.get() = " + optional.get());
        }

        Optional<Student> optional2 = studentList.parallelStream().filter(student -> Student.Address.BJ.equals(student.getAddress())).findFirst();

        if (optional2.isPresent()) {
            System.out.println("findFirst: optional2.get() = " + optional2.get());
        }
        // findAny 在多线程的情况下，哪个线程先执行完，就用谁的。

    }

    @Test
    public void testForeach() {
        // foreach
        // 遍历流。 就是遍历流中的数据。

        // 北京的同学。 身高 170及以下的

        List<Student> studentList = new StudentList().studentList;

        studentList.stream().filter(student -> Student.Address.BJ.equals(student.getAddress()))
                .filter(student -> student.getHeight() <= 170).forEach(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) {
                        System.out.println(student);
                    }
                });

    }
}
