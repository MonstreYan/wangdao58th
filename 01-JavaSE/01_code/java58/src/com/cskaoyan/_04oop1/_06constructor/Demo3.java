package com.cskaoyan._04oop1._06constructor;

/**
 * @author Common-zhou
 * @since 2024-03-05 15:55
 */
public class Demo3 {
    public static void main(String[] args) {
        // 20 岁的 Java老师  hubei
        Teacher3 teacher3 = new Teacher3("Java", 20, "hubei");

        // 属性设置进去了。 通过构造方法设置进去了。
        teacher3.teach();

    }
}


class Teacher3 {
    public String course;
    public int age;
    public String address;


    // 构造方法。
    // [权限修饰符] 类名(){
    //     方法体。
    // }

    // 无参构造方法。
    public Teacher3() {
    }

    // 有参构造方法
    public Teacher3(String course, int age, String address) {
        // 构造方法， 主要的目的。 为成员变量赋值。
        // 将传入的 course属性，赋值给当前对象的course属性。
        this.course = course;
        this.age = age;
        this.address = address;
    }

    public void teach() {
        // 上课。  打印  多少岁的老师，上 ** 课
        System.out.println(age + "岁的老师，教" + course + "课");
    }

}
