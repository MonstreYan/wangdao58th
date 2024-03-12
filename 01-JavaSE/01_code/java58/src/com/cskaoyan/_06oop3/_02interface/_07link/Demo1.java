package com.cskaoyan._06oop3._02interface._07link;

/**
 * @author Common-zhou
 * @since 2024-03-12 15:27
 */
public class Demo1 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.show();

        // 链式调用： 调用的方式就像链条一样，一个接一个
        // 为什么能一直点下去？
        // 方法的返回值。
        // 今后见到这种写法，认识这是链式调用。
        // 原因是： 因为方法的返回值是引用，所以才能一直点。
        new Student().getStudent().getStudent().getStudent().getTeacher().show();
    }
}
