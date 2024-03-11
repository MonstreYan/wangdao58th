package com.cskaoyan._05oop2._02extends._10hiddern;

/**
 * 研究父类和子类。 如果有同名的时候，主要研究两个范围
 * 1.访问的范围。  使用这个引用，能 "点出来"(访问) 哪些属性
 * 2.访问的结果。如果父子类有同名，现在点出来的是父类属性，还是子类属性结果
 *
 * @author Common-zhou
 * @since 2024-03-11 10:21
 */
public class Demo2 {
    public static void main(String[] args) {
        Son2 son2 = new Son2();
        Father2 father2 = new Son2();

        // 访问范围：就是有一些东西能点出来。
        // String name = son2.name;
        // son2.fatherAge1

        // father2.fatherAge1

        //  对于变量来说： 编译看左边。运行看左边。
        // 如果是个父类引用，只能看到父类的变量。
        // father2.fatherAge1
        // father2.fatherName1
        // father2.name
        // 如果是子类引用，能看到子类的变量、 父类也可以
        // son2.name

        // 运行看左边。 左边是什么类型，访问到的就是左边的变量。
        // 如果父类和子类都有同名的变量， 使用父类引用访问，拿到的就是父类中的变量；使用子类引用访问，拿到的就是子类的变量
        System.out.println("son2.name = " + son2.name);

        System.out.println("father2.name = " + father2.name);


    }
}

class Father2 {
    String fatherName1;
    int fatherAge1;
    String name = "father2Name";
}

class Son2 extends Father2 {
    String sonName;
    int sonAge;
    String name = "son2Name";
}


