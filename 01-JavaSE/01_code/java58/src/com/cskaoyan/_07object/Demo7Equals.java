package com.cskaoyan._07object;

import org.junit.Test;

import java.util.Objects;

/**
 * 如果类中有引用数据类型成员变量，需要去调用它们的equals方法完成比较。这就意味着还需要重写这个类的equals方法。
 * <p>
 * 比如Student这个类，需要完成比较；
 * Student里面，有个Address.  Student需要重写equals。 Address也需要重写equals。
 *
 * @author Common-zhou
 * @since 2024-03-15 15:17
 */
public class Demo7Equals {
    @Test
    public void test1() {
        Address7 address71 = new Address7("hubei", "wuhan");
        Address7 address72 = new Address7("hubei", "wuhan");

        Student7 student71 = new Student7("陈健", 19, address71);
        Student7 student72 = new Student7("常旭", 18, address72);

        Student7 student73 = new Student7("陈健", 19, address71);
        Student7 student74 = new Student7("陈健", 19, address72);

        System.out.println("student71.equals(student72) = " + student71.equals(student72));

        System.out.println("student71.equals(student73) = " + student71.equals(student73));
        System.out.println("student74.equals(student71) = " + student71.equals(student74));

    }
}


class Student7 {
    String name;
    int age;

    Address7 address7;

    public Student7(String name, int age, Address7 address7) {
        this.name = name;
        this.age = age;
        this.address7 = address7;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        // if (!(object instanceof Student7 student7)) return false;
        if (!(object instanceof Student7)) return false;
        Student7 student7 = (Student7) object;

        return age == student7.age && Objects.equals(name, student7.name) && Objects.equals(address7, student7.address7);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address7);
    }


}

class Address7 {
    String province;
    String city;

    public Address7(String province, String city) {
        this.province = province;
        this.city = city;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Address7)) return false;
        Address7 address7 = (Address7) object;


        return Objects.equals(province, address7.province) && Objects.equals(city, address7.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(province, city);
    }
}
