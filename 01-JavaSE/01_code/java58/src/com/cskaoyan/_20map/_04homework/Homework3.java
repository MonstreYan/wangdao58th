package com.cskaoyan._20map._04homework;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author Common-zhou
 * @since 2024-04-06 09:34
 */
public class Homework3 {
    @Test
    public void test1() {
        Student s1 = new Student("zs", 100, 100, 100);
        Student s2 = new Student("ls", 90, 90, 90);
        Student s3 = new Student("wu", 90, 90, 90);
        Student s4 = new Student("zl", 85, 85, 85);
        Student s5 = new Student("cf", 100, 100, 100);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int totalScore1 = o1.getChineseScore() + o1.getEnglishScore() + o1.getMathScore();
                int totalScore2 = o2.getChineseScore() + o2.getEnglishScore() + o2.getMathScore();
                return totalScore2 - totalScore1;
            }
        });

        System.out.println(students);

        for (Student student : students) {
            // 输出到文件。 序列化、反序列化。
            // System.out.println(student);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(student.name).append(",").append(student.chineseScore).append(",").append(student.mathScore).append(",").append(student.englishScore);

            System.out.println(stringBuilder.toString());
        }
    }


    @Test
    public void test2() {
        // 关于HashMap  Hashtable的顺序问题。
        // 无序。 随机。
        // zs  ls  wu  zl
        // ls  zs  wu zl
        // zl  wu  ls  zs

        Map<Integer, String> map = new HashMap<>();


        map.put(1, "yi");
        map.put(3, "yi");
        map.put(2, "yi");
        map.put(5, "yi");
        map.put(4, "yi");
        map.put(6, "yi");
        map.put(31, "yi");
        map.put(38, "yi");
        map.put(34, "yi");

        System.out.println(map);

        // 为什么是  1 2 3 4 5 6
        // 1.计算hash值
        // 2.对数组长度进行取余
    }


    @Test
    public void test3() throws IOException {
        // 请设计一个猜数字小游戏，可以试玩5次。
        // 试玩结束之后，给出提示：游戏试玩结束，
        // 请付费。(要求即使把程序重启也总共只能猜5次) (Properties: 读取和存文件记录猜数字次数)

        // 猜数小游戏。 只能猜5次。
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("a.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String timesFromProperties = properties.getProperty("key1", 5 + "");

        int times = Integer.parseInt(timesFromProperties);

        while (times > 0) {
            // 开始猜数

            times--;

            properties.setProperty("key1", times + "");
            properties.store(new FileOutputStream("a.properties"), "123456");
        }

    }


    @Test
    public void test4() throws IOException {
        // 第一种写法： 直接将配置信息，写在代码中。
        String username = "admin";
        String password = "123456789";

        // 第二种写法。将配置信息，写在配置文件中。
        Properties properties = new Properties();
        properties.load(new FileInputStream("a.properties"));

        String username1 = properties.getProperty("username");
        String password1 = properties.getProperty("password");
    }
}


class Student implements Serializable, Comparable<Student> {
    String name;
    int chineseScore;
    int mathScore;
    int englishScore;
    int totalScore;

    public Student(String name, int chineseScore, int mathScore, int englishScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.totalScore = chineseScore + mathScore + englishScore;
    }

    public String getName() {
        return name;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", chineseScore=" + chineseScore + ", mathScore=" + mathScore + ", englishScore=" + englishScore + '}';
    }

    @Override
    public int compareTo(Student s) {
        return Integer.compare(s.totalScore, this.totalScore);
    }
}
