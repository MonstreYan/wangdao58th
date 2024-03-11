package com.cskaoyan._05oop2._02extends._00homework;

/**
 * 一、之前，我们学习过一个对象的初始化。 先回顾一下：
 * 1.类加载。  new Student();
 * 2.进行各种赋值。
 * 1）默认初始化（一定在第一步。）
 * 2）显式赋值    谁在上，就先执行水。
 * 3）构造代码块
 * 4）构造器赋值。 （一定在最后一步）
 *
 * 二、现在，在学习了继承之后。 在子类中，可以访问父类的成员变量，这时候，我们就要知道。 父类和子类是怎样完成初始化的
 * 1.类加载。（先父后子）
 * 2.初始化对象。
 *  BaseAnimal   Animal  new Dog();   ==》 一定要不择手段，先进行父类对象的初始化。
 *  先进行父类对象的初始化。
 *
 *  隐式对象初始化
 *  显式对象初始化
 *    子类  父类。
 *    子类，在构造方法中，显式调用了super()，这个就是 显式对象初始化； 如果没有调用。
 *
 */
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
