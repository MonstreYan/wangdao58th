package com.cskaoyan._04oop1._03reference;

/**
 * @author Common-zhou
 * @since 2024-03-05 11:30
 */
public class Demo4 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.name = "景天";
        // t1.age = 10;

        Teacher t2 = new Teacher();
        t2.name = "石头";

        Teacher t3 = t2;
        t3.name = "空灵";

        System.out.println(t2.name);
    }
}

class Teacher {
    public String name;
}
