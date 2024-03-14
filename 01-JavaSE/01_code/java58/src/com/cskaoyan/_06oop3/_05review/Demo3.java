package com.cskaoyan._06oop3._05review;

/**
 * ===================================数组操作， 自己一定要熟悉。
 * <p>
 * 数组这块的代码，大家一定要掌握。
 *
 * @author Common-zhou
 * @since 2024-03-14 10:27
 */
public class Demo3 {
    public static void main(String[] args) {
        test1();

        test2();

        // 现在要存储一个学校的学生。 信息都能完整存储上去。
        // Student[]
        // 数组是用存储大量数据的
        // Student: 是用来存储。一个人的完整信息的。

    }

    private static void test2() {
        // 类和对象，学完了。
        Student2[] students = new Student2[5];
        students[0] = new Student2("zs", 90);
        students[1] = new Student2("ls", 70);
        students[2] = new Student2("wu", 60);
        students[3] = new Student2("zl", 95);
        students[4] = new Student2("liuba", 93);


        // 写这种代码，如果没思路。 先写注释。 用注释梳理清楚思路。

        // 1.把第一个学生认为是最高的分数学生
        Student2 hightScoreStudent = students[0];

        // 2.循环比较（对比）， 如果当前学生分数高于第一个（最高）学生，这时候把最高分数学生，换成当前学生。

        for (Student2 student : students) {
            if (student.score > hightScoreStudent.score) {
                hightScoreStudent = student;
            }
        }

        // 现在，想找出最高分数的学生
        System.out.println(hightScoreStudent.name + "___" + hightScoreStudent.score);
    }

    private static void test1() {
        int[] nums = {80, 100, 90, 95, 99, 98, 92};

        // 找最高分。
        // 还要返回它的下标

        // 1.主体采用打擂台的方式。 也就是先假设第一个人最高。 然后每一个人挨个上去，和第一个人进行比较
        // 如果上去的这个人比较厉害，这时候就留比较厉害的这个人。
        int lastHighScore = nums[0];
        int highScoreIndex = -1;

        for (int i = 1; i < nums.length; i++) {
            int currentScore = nums[i];
            if (currentScore > lastHighScore) {
                lastHighScore = currentScore;
                highScoreIndex = i;
            }
        }

        System.out.println(lastHighScore);
        System.out.println(highScoreIndex);
    }
}


class Student2 {
    String name;
    int score;

    public Student2(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
