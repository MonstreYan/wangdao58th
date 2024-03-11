package com.cskaoyan._05oop2._02extends._10hiddern;

/**
 * @author Common-zhou
 * @since 2024-03-11 10:34
 */
public class Demo4 {
    public static void main(String[] args) {
        System.out.println("Person.nationality = " + Person.nationality);

        System.out.println("Student.nationality = " + Student.nationality);
    }
}

class Person {
    static String nationality = "personNationality";
}

class Student extends Person {
    static String nationality = "studentNationality";
}
