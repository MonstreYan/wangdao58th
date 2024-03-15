package com.cskaoyan._07object;

import org.junit.Test;

import java.util.Objects;

/**
 * equals方法， 用来判断两个对象是否相等的方法
 *
 * @author Common-zhou
 * @since 2024-03-15 14:34
 */
public class Demo6Equals {

    @Test
    public void test1() {
        Object o = new Object();

        boolean equals = o.equals(null);

        // boolean 代表是否相等。
        // 为什么只传入了一个对象： 因为这是个成员方法，使用当前对象和传入的对象进行比较
        // 默认实现：直接比较的地址。
        // public boolean equals(Object obj) {
        //     return (this == obj);
        // }
    }


    @Test
    public void test2() {
        // 默认的equals方法，太过于严苛。 一般在工作中，会将equals方法进行重写。
        // 重写equals，有一个准则，就是让equals返回值 和里面的属性有关。
        Student6 student6 = new Student6("zs", 18, "hubei");
        boolean equals = student6.equals(null);
        System.out.println(equals);


        Student6 student61 = new Student6("zs", 18, "hubei");

        System.out.println("student6.equals(student61) = " + student6.equals(student61));
    }

    @Test
    public void test3() {
        // 如果name为空，这时候，会怎样？

        Student6 student6 = new Student6("zs", 18, null);
        Student6 student61 = new Student6("zs", 18, "zs");

        // 空指针在很多地方都会出。 写代码的时候，一定要注意防范。
        System.out.println("student6.equals(student61) = " + student6.equals(student61));
    }

    @Test
    public void test4() {

        // 比如，你现在要判断传入的字符串， 是  zs 。一般怎么写？

        String inputUserName = null;

        // if (inputUserName.equals("zs")) {
        //
        // }
        //
        // if ("zs".equals(inputUserName)) {
        //
        // }

        // 为啥这样写，就不会出空指针  ==》 取决
        // "zs".equals(null) ===> 取决于equals方法怎么写
        // if ("zs".equals(inputUserName)) {
        //
        // }


    }

}


class Student6 {
    String name;
    int age;
    String address;

    public Student6(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        // 重写的写法。
        //  1.检查类型。
        // 为什么要把obj == null 写前面？
        // obj == null || this.getClass() != obj.getClass()  让短路或帮助检查一个是。 obj不为null。 不为null的时候才能
        // obj.getClass();
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        // obj走到这，说明什么 ===》 说明obj是个 Student6
        Student6 otherStudent6 = (Student6) obj;

        // 2.检查属性是否相等
        // 这块有没有问题？
        // this.name  可能为null。   可能会出空指针。

        // 这个写法，在处理null的时候，有问题。  比如name为null。
        // return this.name.equals(otherStudent6.name) && this.address.equals(otherStudent6.address) && this.age == otherStudent6.age;

        // 看这个方法，会认为是Object提供的一个equals方法。

        // 1.null     zs   ===》 false
        // 2.null    null   ===> true
        // 3. zs    null   ==>   false  不会出空指针
        // 4. zs    zs   ===> true

        // 有效避免空指针异常。


        // (a == b) || (a != null && a.equals(b));
        // false     || (zs.equals(null))

        return Objects.equals(this.name, otherStudent6.name) && Objects.equals(this.address, otherStudent6.address) && this.age == otherStudent6.age;
    }
}


class Student61 {
    String name;
    int age;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        // 允许接收该类，及该类的子类。
        // object instanceof Student61 student61

        // object instanceof Student61
        // Student61 student61 = (Student61)object;
        // 就是，如果object是Student61. 直接将object转成这个类型，名字student61
        // if (!(object instanceof Student61 student61)) return false;
        if (!(object instanceof Student61)) return false;
        Student61 student61 = (Student61) object;

        // 子类  is-a 父类。

        // 不用管它。 用哪个都行。  或者公司里面用哪个。
        // 因为公司里面写代码，继承用的不多。

        return age == student61.age && Objects.equals(name, student61.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}


class Student63 {
    String name;
    double d1;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Student63)) return false;

        Student63 student63 = (Student63) object;

        return Double.compare(d1, student63.d1) == 0 && Objects.equals(name, student63.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, d1);
    }
}
