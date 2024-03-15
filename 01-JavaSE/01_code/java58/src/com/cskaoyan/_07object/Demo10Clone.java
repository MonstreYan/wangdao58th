package com.cskaoyan._07object;

import org.junit.Test;

/**
 * clone方法，就是帮你做个事，帮你将原来的对象克隆一份。 （创建一个新的，新的和之前属性一模一样。）
 * <p>
 * Student(id=7，name=zhangsan, address=hubei)
 * Student(id=7，name=zhangsan, address=hubei)
 * <p>
 * 要使用clone方法，
 * 1.将clone方法的 权限改掉。 之前是protected，现在，改成public
 * 2.要实现一个接口。Cloneable 接口。 如果不实现这个接口，会直接报错。
 *
 * @author Common-zhou
 * @since 2024-03-15 16:05
 */
public class Demo10Clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student10 student10 = new Student10("zs", 10);
        Object clone = student10.clone();

        // clone 是干什么的？
        // 创建当前对象的克隆对象。
        System.out.println(clone);

        // 克隆、之后。怎么确定是否和之前的是同一个对象？
        // == 判断地址。
        System.out.println("(clone == student10) = " + (clone == student10));

        Student10 clonedStudent10 = (Student10) clone;

        System.out.println(clonedStudent10.name);
        System.out.println(clonedStudent10.age);

        // toString()
        // com.cskaoyan._07object.Student10@677327b6
    }

    @Test
    public void test1() {
        // clone方法就是直接在当前对象的基础上，重新帮你生成一个副本。

        // Student  zs   19
        // Student  zs   19

    }

    @Test
    public void test3() throws CloneNotSupportedException {
        // 现在，要完成对Student11的克隆。 有哪些步骤。
        // 1.重写访问权限。  protected public
        // 2.实现Cloneable接口。
        Address10 address10 = new Address10("河南", "郑州");

        Student11 student11 = new Student11("景天", 19, address10);

        Object clone = student11.clone();
        Student11 student12 = (Student11) clone;

        System.out.println(student11 == student12);
        System.out.println(student12);
    }

    @Test
    public void test4() {
        // Cloneable里面没有任何方法。它的作用，其实是个标识符。
    }

    @Test
    public void test5() {
        // Student11进行了clone。 但是对于里面的Address10.其实并没有克隆， 只是将原先的地址进行了拷贝。
        // 如果想进行深拷贝，应该怎么做。
    }
}

class Student10 implements Cloneable {
    String name;
    int age;

    public Student10(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}


class Student11 implements Cloneable {
    String name;
    int age;
    Address10 address10;

    public Student11(String name, int age, Address10 address10) {
        this.name = name;
        this.age = age;
        this.address10 = address10;
    }

    @Override
    public String toString() {
        return "Student11{" + "name='" + name + '\'' + ", age=" + age + ", address10=" + address10 + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Address10 {
    String province;
    String city;

    public Address10(String province, String city) {
        this.province = province;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address10{" + "province='" + province + '\'' + ", city='" + city + '\'' + '}';
    }
}
