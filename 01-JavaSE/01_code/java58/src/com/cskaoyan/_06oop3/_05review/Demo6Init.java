package com.cskaoyan._06oop3._05review;

public class Demo6Init {

    public static void main(String[] args) {
        HighStudent highStudent = new HighStudent(666, 888, "hello");
        System.out.println(highStudent.psVar);
    }
}

class Person {
    static {
        System.out.println("Person类加载");
    }

    {
        System.out.println("Person构造代码块");
    }

    public Person() {
        System.out.println("Person类的无参构造");
    }
}

class Student extends Person {
    static {
        System.out.println("Student类加载");
    }

    {
        System.out.println("Student构造代码块");
    }

    int sVar;
    String sVarString;

    public Student() {
        System.out.println("Student类无参构造");
    }

    public Student(int sVar) {
        System.out.println("Student int构造方法");
        this.sVar = sVar;
    }

    public Student(int sVar, String sVarString) {
        this(sVar);
        System.out.println("Student int String构造方法");
        this.sVarString = sVarString;
    }
}

class HighStudent extends Student {
    static {
        System.out.println("HighStudent类加载");
    }

    {
        System.out.println("HighStudent构造代码块");
    }

    int psVar = 10;

    public HighStudent(int psVar, int sVar, String sVarString) {
        super(sVar, sVarString);
        System.out.println("HighStudent类的 三参构造");
        this.psVar = psVar = 100;
    }
}
