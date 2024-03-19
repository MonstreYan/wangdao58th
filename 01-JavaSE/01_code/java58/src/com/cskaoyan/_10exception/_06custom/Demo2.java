package com.cskaoyan._10exception._06custom;

/**
 * @author Common-zhou
 * @since 2024-03-19 15:23
 */
public class Demo2 {

    public static void main(String[] args) {
        Student student = new Student("zs", 19);

        addStudent(student);
    }

    private static void addStudent(Student student) {

        // 异常就是用来帮你表示一些数据有问题的情况的。
        // 上来先判断，数据有问题。 直接开始报错。
        // 报错了，就可以避免一个问题。 数据的问题。别人觉得是我的bug。

        if (student == null || student.getName() == null) {
            throw new IllegalArgumentException("student和student的名字不能为空");
        }

        //
        if (student.getScore() < 0 || student.getScore() > 100) {
            throw new IllegalArgumentException("student的分数应该在0-100之间。 ");
        }


    }
}
