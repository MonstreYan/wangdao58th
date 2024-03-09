package com.cskaoyan._05oop2._02extends._08init;

/**
 * @author Common-zhou
 * @since 2024-03-09 11:12
 */
public class Demo8Init {
    public static void main(String[] args) {
        HighStudent8 highStudent8 = new HighStudent8(666, 888, "hello");
        System.out.println(highStudent8.psVar);

        // 1.先进行类加载。（先父猴子）
        // 2.初始化。 先进行父类初始化，父类初始完了再子类。

        // 类加载，是个懒加载。 有的类，可能main方法执行到才会加载。
        // 懒人：
        // 懒汉模式； 饱汉模式

    }
}

class Person8 {
    static {System.out.println("Person8类加载");}

    {System.out.println("Person8构造代码块");}

    public Person8() {
        System.out.println("Person8类的无参构造");
    }
}

class Student8 extends Person8 {
    static {System.out.println("Student8类加载");}
    {System.out.println("Student8构造代码块");}
    int sVar;
    String sVarString;
    public Student8() {
        System.out.println("Student8类无参构造");
    }
    public Student8(int sVar) {
        System.out.println("Student8 int构造方法");
        this.sVar = sVar;
    }
    public Student8(int sVar, String sVarString) {
        this(sVar);
        System.out.println("Student8 int String构造方法");
        this.sVarString = sVarString;
    }
}

class HighStudent8 extends Student8 {
    // 静态代码块： 在类加载的时候会运行
    static {System.out.println("HighStudent8类加载");}

    {System.out.println("HighStudent8构造代码块");}

    int psVar = 10;

    public HighStudent8(int psVar, int sVar, String sVarString) {
        super(sVar, sVarString);
        System.out.println("HighStudent8类的 三参构造");
        this.psVar = psVar = 100;
    }
}
