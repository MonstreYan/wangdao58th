package com.cskaoyan._01basic._01identifier;

/**
 * - 包名所有字母一律小写，例如com.cskaoyan.example01（多级包名用“.”隔开）
 * - 类和接口每个单词的首字母大写，例如Student，Runnable，MyFirstProgram。（大驼峰）
 * - 常量名所有字母都大写，单词之间用下划线连接，例如 STUDENT_KEY
 * - 变量名和方法名的第一个单词首字母小写，从第二个单词开始每个首字母大写，例如，userName，getStudentName。（小驼峰）
 *
 * @author Common-zhou
 * @since 2024-02-29 14:59
 */
public class Demo2 {
    public static void main(String[] args) {
        // 1.写包名的时候，需要注意。 全小写。

        // 2.类和接口，每个单词都首字母大写，然后单词和单词之间，用驼峰。  大驼峰。
        // 湖北学生人数。   hubeiStudentCount
        // 不能用中文，也不能用拼音。
        // 驼峰就是： 在单词和单词之间，帮助大家去认识单词的界限的。
        // 学生分数： StudentScore
        // 切换大小写的时候： shift
        // StudentScore

        // 3.常量，所有的字母全大写，
        // 学生分数  STUDENT_SCORE

        // 4.变量名和方法名， 使用小驼峰。 第一个单词是小写， 后续使用大写字母来更换单词。
        // 湖北年轻学生人数
        // hubei  young student count
        // hubeiYoungStudentCount  :


        // 变量名里叫这些，非常不推荐
        //  i  j  k   a   b   c
        int i = 20;

        int a = 10;
        // int englishTeacherAge = 20;
        // for (int i = 0; i < 10; i++) {
        //
        // }


    }
}
