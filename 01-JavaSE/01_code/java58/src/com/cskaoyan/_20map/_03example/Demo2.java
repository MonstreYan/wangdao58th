package com.cskaoyan._20map._03example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * - 比如你想统计一个班上每个省份的学生人数。应该怎么设计这个Map？
 * - 想统计一个班上，男生和女生的人数
 * - 一个班级的，语文分按照 [0,60), [60,80), [80,100]分三个层级 差，良，优秀。怎么统计每个层级的人数？(抽方法有什好处)
 *
 * @author Common-zhou
 * @since 2024-04-02 16:29
 */
public class Demo2 {

    @Test
    public void test1() {
        // 比如你想统计一个班上每个省份的学生人数。应该怎么设计这个Map？
        // key是省份； value是人数。
    }

    @Test
    public void test2() {
        // [0,60), [60,80), [80,100]
        // 产品第一版需求：进步空间巨大  还有进步空间  很棒

        // [0,20)[20,35),[35,45),[45,60), [60,80), [80,100]


        // 一个班级的，语文分按照 [0,60), [60,80), [80,100]分三个层级 差，良，优秀。怎么统计每个层级的人数？(抽方法有什好处)
        List<Score> scoreList = generateScoreList();

        // Map。
        // key是什么东西， value 是什么东西？
        // key是层级， value是层级的人数。

        Map<String, Integer> map = new HashMap<>();

        for (Score score : scoreList) {
            int subjectScore = score.getScore();

            String level = getScoreLevel(subjectScore);
            Integer count = map.getOrDefault(level, 0);
            map.put(level, count + 1);
        }

        System.out.println(map);


    }

    private static String getScoreLevel(int subjectScore) {
        String level = "";
        if (subjectScore < 60) {
            // 差
            level = "进步空间巨大";
        } else if (subjectScore < 80) {
            // 良
            level = "还有进步空间";
        } else {
            // 优秀
            level = "很棒";
        }
        return level;
    }

    @Test
    public void test3() {
        // 一个班级的，数学分按照 [0,60), [60,80), [80,100]分三个层级 差，良，优秀。怎么统计每个层级的人数？(抽方法有什好处)
        List<Score> scoreList = generateScoreList();

        Map<String, Integer> map = new HashMap<>();

        for (Score score : scoreList) {
            int subjectScore = score.getScore();

            String level = getScoreLevel(subjectScore);
            Integer count = map.getOrDefault(level, 0);
            map.put(level, count + 1);
        }

        System.out.println(map);


    }


    private List<Score> generateScoreList() {

        List<Score> scoreList = new ArrayList<>();

        for (int i = 0; i <= 100; i++) {
            Score score = new Score();
            score.setScore(i);
            scoreList.add(score);
        }
        return scoreList;

    }
}


class Score {
    String studentName;
    int score;
    String subject;

    public String getStudentName() {
        return studentName;
    }

    public Score setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public int getScore() {
        return score;
    }

    public Score setScore(int score) {
        this.score = score;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Score setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    @Override
    public String toString() {
        return "Score{" + "studentName='" + studentName + '\'' + ", score=" + score + ", subject='" + subject + '\'' + '}';
    }
}
