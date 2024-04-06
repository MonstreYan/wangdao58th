package com.cskaoyan._21stream._04endstream;

import com.cskaoyan._21stream._01introduct.Student;
import com.cskaoyan._21stream._01introduct.StudentList;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * @author Common-zhou
 * @since 2024-04-06 15:56
 */
public class Demo3Reduce {
    @Test
    public void test1() {
        // reduce: 将参与计算的元素，按照某种方式减少。
        // 我给你60个学生的身高。 现在需要找出最高的身高。
        // 1.排序。 nlog(n)
        // 2.遍历。

        // 将参与计算的学生身高，按照 取两个较高的方法进行处理。
        // 170 172 175 177 180  162 165
        // 180

        List<Student> studentList = new StudentList().studentList;

        Optional<Integer> optional = studentList.stream().map(student -> student.getHeight()).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Math.max(integer, integer2);
            }
        });

        if (optional.isPresent()) {
            System.out.println("optional.get() = " + optional.get());
        }
    }

    @Test
    public void test2() {
        // 求班级的身高的总和

        List<Student> studentList = new StudentList().studentList;

        Optional<Integer> optional = studentList.stream().map(student -> student.getHeight()).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });

        System.out.println("optional.get() = " + optional.get());
        // reduce: 将参加计算的元素，按照某种方式进行减少。
        // 将两个数据，变成一个。 说的是数目。
    }

    @Test
    public void test3() {
        //  <2>二参情况: T reduce(T identity, BinaryOperator<T> accumulator);
        List<Student> studentList = new StudentList().studentList;

        // 最开始的值。
        Integer reduce = studentList.stream().map(student -> student.getHeight()).reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });

        System.out.println(reduce);

    }
}
