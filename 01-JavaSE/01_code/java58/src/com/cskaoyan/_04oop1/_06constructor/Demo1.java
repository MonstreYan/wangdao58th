package com.cskaoyan._04oop1._06constructor;

/**
 * 创建一个教师类，有课程和年龄，地址三个属性，行为是上课。
 * 现在我们需要创建以下对象：
 * 1. 20岁的Java老师对象  湖北
 * 2. 21岁的C++老师对象   湖南
 * 3. 22岁的Python老师对象 河南
 *
 * @author Common-zhou
 * @since 2024-03-05 15:21
 */
public class Demo1 {
    public static void main(String[] args) {
        // 20岁的Java老师对象  湖北

        Teacher1 teacher1 = new Teacher1();
        teacher1.course = "Java";
        teacher1.age = 20;
        teacher1.address = "湖北";

        Teacher1 teacher2 = new Teacher1();
        teacher2.course = "C++";
        teacher2.age = 21;
        teacher2.address = "湖南";

        Teacher1 teacher3 = new Teacher1();
        teacher3.course = "Python";
        teacher3.age = 22;
        teacher3.address = "河南";

        teacher1.teach();
        teacher2.teach();
        teacher3.teach();

    }
}

class Teacher1 {
    // 课程和年龄，地址三个属性
    public String course;
    public int age;
    public String address;

    public void teach() {
        // 上课。  打印  多少岁的老师，上 ** 课
        System.out.println(age + "岁的老师，教" + course + "这个课");
    }

}
