package com.cskaoyan._07object;

import org.junit.Test;

/**
 * 在toString方法中，不要做一些奇奇怪怪的代码。 赋值代码、业务代码也不要写。
 * 尽量只做，打印里面的成员变量。
 * 你要把它作为一个纯粹的代码。如果你在里面写其他代码，可能会出奇怪bug。
 *
 * @author Common-zhou
 * @since 2024-03-15 11:11
 */
public class Demo4ToString {
    @Test
    public void test1() {
        Student4 student4 = new Student4("zhangsan");

        System.out.println(student4.name);
        // 因为在debug的情况下，它会偷偷调用 toString方法
    }

    @Test
    public void test2() {
        // 为了避免空指针异常，打印对象名或对象名拼接字符串中的隐含调用的toString方法能不写出来就不要写出来，不要画蛇添足。
        // 因为隐式调用不会空指针异常，但直接调用方法完全可能出现空指针异常。
        Demo4ToString demo4ToString = new Demo4ToString();

        System.out.println(demo4ToString);
        System.out.println(demo4ToString.toString());

        Demo4ToString demo4ToString1 = null;
        System.out.println(demo4ToString1);
        // System.out.println(demo4ToString1.toString());
    }

    @Test
    public void test3() {
        // 如果类中有（自定义）引用数据类型成员变量，也需要重写它的toString方法，不然就会打印地址值了。
        // 如果Student4中，有一个Address 是自定义的类。这个类型也需要重写toString方法。
        // 不然等会打印toString 的时候。打印address 出来的是地址。

        // Student41{name='jingtian', age=18, address4=com.cskaoyan._07object.Address4@7dc36524}

        Address4 address4 = new Address4("henan", "zhengzhou");

        Student41 student41 = new Student41("jingtian", 18, address4);

        System.out.println(student41);

        // Address重写了toString方法后。 结果
        // Student41{name='jingtian', age=18, address4=Address4{province='henan', city='zhengzhou'}}

    }
}

class Student4 {
    String name;

    public Student4(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        this.name = "景天";
        return "Student4{" + "name='" + name + '\'' + '}';
    }
}


class Student41 {
    String name;
    int age;
    Address4 address4;

    public Student41(String name, int age, Address4 address4) {
        this.name = name;
        this.age = age;
        this.address4 = address4;
    }

    @Override
    public String toString() {
        return "Student41{" + "name='" + name + '\'' + ", age=" + age + ", address4=" + address4 + '}';
    }
}

class Address4 {
    String province;
    String city;

    public Address4(String province, String city) {
        this.province = province;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address4{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
