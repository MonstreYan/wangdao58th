package com.cskaoyan._07object;

import org.junit.Test;

import java.util.Objects;

/**
 * @author Common-zhou
 * @since 2024-03-15 11:28
 */
public class Demo5Equals {
    @Test
    public void test1() {
        Object o = new Object();

        System.out.println("o.equals(new Object()) = " + o.equals(new Object()));

        // 默认实现，就是 (this == obj);
        // 其实就是比较的地址。

        // 比较两个引用数据类型相等，用equals方法。   ==

        // 什么时候，能返回true?
        Object o1 = o;

        System.out.println("o1.equals(o) = " + o1.equals(o));
    }

    @Test
    public void test2() {
        // 在生活中，我们怎么认为两对象相等？

        // 需要比较两个对象，只要对象里面的属性全部相等。
        // Dog  Cat  ==> 是否相等？ 类型也应该相等。

        // 一般，自己重写equals。 会首先比较类型。 如果类型相等，再往下比， 比属性。 属性如果完全相同，认为相同。
    }

    @Test
    public void test3() {
        Student5 student51 = new Student5("zhangsan", 18, "hubei", "110");
        Student5 student52 = new Student5("zhangsan", 19, "hubei", "110");

        System.out.println("student51.equals(student52) = " + student51.equals(student52));

        // 所以equals的写法。 一般情况下，先比较类型
        // 类型如果不同，直接返回false；
        // 类型如果相等，再挨个比较属性。
        // 写法非常固定。 idea
    }
}

class Student5 {
    String name;
    int age;
    String address;
    String phone;

    public Student5(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (obj.getClass() != this.getClass()) {
    //         // 两个类型相等， 才往下接着比
    //         return false;
    //     }
    //
    //     // 只要代码走到这一行，说明什么？  类型相等
    //     // 为什么需要强转
    //     Student5 student5 = (Student5) obj;
    //
    //     return this.name.equals(student5.name) && this.age == student5.age
    //             && this.address.equals(student5.address) && this.phone.equals(student5.phone);
    // }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Student5 student5 = (Student5) object;

        // Arrays Objects Collections ==> 工具类

        return age == student5.age && Objects.equals(name, student5.name) && Objects.equals(address, student5.address) && Objects.equals(phone, student5.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address, phone);
    }
}
