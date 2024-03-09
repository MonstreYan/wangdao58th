package com.cskaoyan._05oop2._02extends._00homework.a;

/**
 * @author Common-zhou
 * @since 2024-03-09 09:34
 */
public class Student {
    public void test1() throws CloneNotSupportedException {
        // 为什么，在Student里面，成员方法，能调用  clone方法？
        // Student  ---> Object
        this.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.clone();
    }

}
