package com.cskaoyan._05oop2._02extends._10hiddern;

/**
 * @author Common-zhou
 * @since 2024-03-11 10:31
 */
public class Demo3 {

    public static void main(String[] args) {

        // 1. 创建父类对象,用父类引用接收，用对象名点访问。
        Father2 father2 = new Father2();

        System.out.println("father2.fatherAge1 = " + father2.fatherAge1);
        System.out.println("father2.fatherName1 = " + father2.fatherName1);

        // 2. 创建子类对象,用子类引用接收，用对象名点访问。
        Son2 son2 = new Son2();
        System.out.println("son2.sonAge = " + son2.sonAge);

        // 3. 创建子类对象,用父类引用接收，用对象名点访问。
        Father2 father21 = new Son2();

        System.out.println("father21.name = " + father21.name);

        // 对于属性来说： 编译看左边，运行看左边。
    }
}
