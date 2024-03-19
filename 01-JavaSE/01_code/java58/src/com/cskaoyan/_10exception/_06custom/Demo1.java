package com.cskaoyan._10exception._06custom;

/**
 * 考试成绩必须在0-100分之间，如果有考试成绩不在这个范围之内，则认为成绩异常。
 * 对于以上的异常，Java语言中显然没有一个对应的“考试分数异常超出范围”的异常，因此该异常需要我们自己来定义。
 * 自定义的异常。 分两类。
 * 1.如果是继承Exception。 就是编译时异常
 * 2.如果是继承RuntimeException 就是运行时异常。
 *
 * @author Common-zhou
 * @since 2024-03-19 15:13
 */
public class Demo1 {
    public static void main(String[] args) throws ScoreExceedRangeException {

        Student student = new Student("zs", -10);

        // int checkNum = checkStudentScoreRange(student);
        checkStudentScoreRange(student);
    }

    private static void checkStudentScoreRange(Student student) {

        if (student == null) {
            throw new NullPointerException("学生对象不对，不能为空");
        }

        // 走到这，说明啥？
        int score = student.getScore();


        if (score < 0 || score > 100) {
            throw new ScoreExceedRangeException("分数必须在0-100之间");
        }

    }

}

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

// 自定义异常，分两步。 第一步，继承； 第二步，可以用它的构造方法
// 继承的是Exception ===> 你的异常就是编译时异常
// 继承的是RuntimeException ==》 你的异常就是运行时异常
// class ScoreExceedRangeException extends Exception {
class ScoreExceedRangeException extends RuntimeException {
    public ScoreExceedRangeException() {
    }

    public ScoreExceedRangeException(String message) {
        super(message);
    }
}
