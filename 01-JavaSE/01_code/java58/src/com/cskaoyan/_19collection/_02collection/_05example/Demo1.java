package com.cskaoyan._19collection._02collection._05example;

import java.util.*;

/**
 * // 1.存储一组学生。包括 姓名 年龄，总分，入学日期(Date) ====> 类。
 * // 2.找出总分最高的学生？
 * // 3.找出总分最低的学生
 * // 4.求平均分
 * // 5.删除低于平均分的学生
 * // 6.找出2年内入学的学生。 也可以思考一下。 2022-09-01
 * // 7.需要删除叫张三的学生
 * // 8.删除年龄小于18的学生
 *
 *
 * 出了bug，怎么找bug？
 *  梳理一下，数据处理的流程，往上。 在哪些地方塞入的输入，在哪些地方修改了数据。
 *
 *
 * @author Common-zhou
 * @since 2024-03-29 16:03
 */
public class Demo1 {
    public static void main(String[] args) {
        Collection<Student> students = generateStudents(20);

        // 2.找出总分最高的学生？
        // 对于一个方法来说： 方法名、入参、返回值
        Student highestScoreStudent = findHighestScoreStudent(students);
        System.out.println(highestScoreStudent);

        // 3.找出总分最低的学生

        // 4.求平均分 总分/人数
        double avgScore = calculateStudentAvgScore(students);

        System.out.println(avgScore);

        // 5.删除低于平均分的学生
        deleteLowAvgScoreStudent(students);


        System.out.println("=============================");

        // 6.找出2年内入学的学生。
        // 2024-3-29   23   22
        // 2022-09-01
        // 需求理解，不一致的时候，一定要确认，一定要问。
        // 按照： 当前日期，往前减两年。

        students = generateStudents(20);
        Collection<Student> enterDateBetween2YearsStudents = findEnterDateBetween2Years(students);

        // 怎么生成日期的？
        System.out.println(enterDateBetween2YearsStudents);

    }

    private static Collection<Student> findEnterDateBetween2Years(Collection<Student> students) {

        Collection<Student> enterDateBetween2YearsStudentCollection = new ArrayList<>();

        // 我写Java， 现在我有一个Date。需要判断这个Date是否在当前时间的两年之内。两年之内，是按这么定义的，比如今天是
        // 2024-03-29 16：42:01。 现在要找 2022-03-29 16：42:01之内的
        // 2024-03-29 16：42:01      2022-03-29 16：42:01
        // 现在时间 - 入学时间 < 365
        //
        for (Student student : students) {
            if (isBetweenTwoYeas(student.getEnterDate())) {
                enterDateBetween2YearsStudentCollection.add(student);
            }

        }

        return enterDateBetween2YearsStudentCollection;
    }

    private static boolean isBetweenTwoYeas(Date enterDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);

        Date twoYearsAgo = calendar.getTime();

        // 检查日期是否在两年之内
        // if (enterDate.after(twoYearsAgo)) {
        //     return true;
        // } else {
        //     return false;
        // }

        return enterDate.after(twoYearsAgo);
    }

    private static void deleteLowAvgScoreStudent(Collection<Student> students) {

        // 1.算平均分。
        double avgScore = calculateStudentAvgScore(students);

        // 2.删除学生。
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student next = iterator.next();
            if (next.getScore() < avgScore) {
                // students.remove(next);
                iterator.remove();
            }
        }

        System.out.println(students);

    }

    private static double calculateStudentAvgScore(Collection<Student> students) {

        // 总分/人数

        // 求总分。
        int totalScore = 0;
        int studentCount = 0;
        for (Student student : students) {
            totalScore += student.getScore();
            studentCount++;
        }

        return 1.0 * totalScore / studentCount;
    }

    private static Student findHighestScoreStudent(Collection<Student> students) {

        // 给你一个学生集合。 怎么找总分最高的？

        // 1. 先用一个学生，来存最高分数的学生。
        Iterator<Student> iterator = students.iterator();

        // students.itetrator()   next()
        Student maxScoreStudent = iterator.next();

        // 2.开始遍历学生。 foreach
        while (iterator.hasNext()) {
            Student currentStudent = iterator.next();
            //  2.1 遍历的时候，比，谁的分高， 就是最高分。 如果大于，用当前替换最高学生。

            if (currentStudent.getScore() > maxScoreStudent.getScore()) {
                maxScoreStudent = currentStudent;
            }
        }

        // maxScore

        return maxScoreStudent;
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


class Student {
    // 姓名 年龄，总分，入学日期(
    private String name;
    private int age;
    private int score;
    private Date enterDate;

    public Student() {
    }

    public Student(String name, int age, int score, Date enterDate) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.enterDate = enterDate;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Student setScore(int score) {
        this.score = score;
        return this;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public Student setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
        return this;
    }


    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", score=" + score + ", enterDate=" + enterDate + '}';
    }
}
