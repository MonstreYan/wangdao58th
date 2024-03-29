package com.cskaoyan._19collection._05example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * 7.需要删除叫 student_0 的学生
 * 8.删除年龄小于18的学生
 *
 * @author Common-zhou
 * @since 2024-03-29 17:23
 */
public class Demo3 {

    public static void main(String[] args) {
        Collection<Student> students = generateStudents(20);

        deleteStudentNameStudent0(students);

        System.out.println(students);


    }

    private static void deleteStudentNameStudent0(Collection<Student> students) {

        // 遍历。
        //  一个一个的学生。比较 student_0 。
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student next = iterator.next();
            if ("student_0".equals(next.getName())) {
                iterator.remove();
            }
        }


    }

    private static Collection<Student> generateStudents(int count) {

        Collection<Student> students = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Student student = new Student();
            student.setName("student_" + i);
            student.setAge(18);
            student.setScore(i);

            //3600 * 1000 * 24 一天的ms
            // 3600 * 1000 * 24 * 30 * 2 两个月的ms
            // i = 10   20个月之前
            // i = 11   22个月之前
            // i = 12   24个月之前
            // i = 13   26个月之前
            // 3600 * 1000 * 24 * 30 * 2 * i: integer multiplication implicitly cast to long
            student.setEnterDate(new Date(System.currentTimeMillis() - 3600L * 1000 * 24 * 30 * 2 * i));
            students.add(student);
        }

        return students;
    }


}
