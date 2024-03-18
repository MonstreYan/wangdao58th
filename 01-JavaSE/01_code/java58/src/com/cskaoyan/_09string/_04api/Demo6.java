package com.cskaoyan._09string._04api;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Common-zhou
 * @since 2024-03-18 16:12
 */
public class Demo6 {
    @Test
    public void test1() {
        // String类的比较功能
        // int compareTo(String str)
        // int compareToIgnoreCase(String str)

        String s = "abc";
        String s1 = "Abc";

        // int代表比较的结果。 如果是正数，说明大； 如果是负数，说明小；如果是0， 相等
        int result = s.compareTo(s1);

        System.out.println(result);

    }

    @Test
    public void test2() {
        // 在Java中，怎么比较大小
        // 基本数据类型。  1  2  3 。就是按照大小顺序进行比较
        // 引用数据类型。  User这种类，怎么比较大小。

        // 在Java中，对于基本数据类型，JVM知道怎么比较大小， 但是对于引用数据类型，JVM不知道怎么比较大小。
        // 所以，你必须要告诉JVM怎么比较大小。
        // 怎么告诉它怎么比较大小：
        // 1.实现Comparable接口。
        // 2.传入一个Comparator比较器。
    }

    @Test
    public void test3() {
        int[] nums = {10, 8, 7, 6, 12, 18, 19};

        System.out.println(Arrays.toString(nums));
        //  Arrays 工具类。
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        User wu = new User("wu", 20);
        User zs = new User("zs", 18);
        User ls = new User("ls", 19);
        User[] users = {ls, zs, wu};
        // 在Java中，你需要让JVM比较大小，要么实现Comparable接口，要么传入Comparator
        Arrays.sort(users);

        System.out.println(Arrays.toString(users));
    }

    @Test
    public void test4() {
        // 在Java中，只要涉及到引用数据类型的比较大小。
        // 1.实现Comparable接口
        // 2.传入一个Comarator接口
        // 比如，现在要对一些Student进行排序。
        // 先按名字排； 名字相同，按年龄排； 年龄相同，按地址排

        Student[] students = new Student[5];

        students[0] = new Student("zs", 18, "hubei");
        students[1] = new Student("zs", 19, "hunan");
        students[2] = new Student("zs", 18, "hunan");
        students[3] = new Student("ls", 18, "hubei");
        students[4] = new Student("ls", 19, "hunan");

        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        // 排完序。
        System.out.println(Arrays.toString(students));
    }

    @Test
    public void test5() {
        // 如果要在Java中，对User这种引用数据类型，排序。 要么实现Comparable接口，要么放Comparator。
    }

    @Test
    public void test6() {
        Student2[] students = new Student2[5];

        students[0] = new Student2("zs", 18, "110");
        students[1] = new Student2("zs", 19, "120");
        students[2] = new Student2("zs", 18, "112");
        students[3] = new Student2("ls", 18, "113");
        students[4] = new Student2("ls", 19, "110");

        // 现在，假设排序规则变了。  按年龄排，年龄排完了按手机号排。
        // 不实现Comparable接口。

        // 这个后面，叫做匿名内部类对象
        Arrays.sort(students, new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {

                // 按年龄排(从大到小)，年龄排完了按手机号排
                int compareResult = o2.age - o1.age;
                compareResult = compareResult != 0 ? compareResult : o1.phone.compareTo(o2.phone);

                return compareResult;
            }
        });

        System.out.println(Arrays.toString(students));

        // Arrays.sort(students, new Student2Comparator());
    }

    @Test
    public void test7() {
        // String是怎么进行比较的。

        String s = "abc";
        String s1 = "Abc";

        System.out.println("s.compareTo(s1) = " + s.compareTo(s1));
    }

}


class Student2Comparator implements Comparator<Student2> {

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return 0;
    }
}


// 实现Comparable。后方有个 <>
// 如果要实现的是个User。 就写User。 如果要实现的是个Student，就写Student
// class User implements Comparable<User>
// class Student implements Comparable<Student>
// 泛型的时候再讲
class User implements Comparable<User> {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(User o) {
        // 这个compareTo方法，就是你告诉JVM，怎么比较大小的。
        // 比如，在你这个学生中，年龄大，就认为大。

        // o有没有可能为null?
        if (o == null) {
            return 1;
        }

        return this.age - o.age;
    }
}

class Student implements Comparable<Student> {
    String name;
    int age;
    String address;


    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }

    @Override
    public int compareTo(Student o) {
        // 这个compareTo方法。在做什么事情。 在告诉JVM，怎么比

        // 先按名字排；
        // 名字相同，按年龄排；
        // 年龄相同，按地址排

        // temp 相当于，知道了 name谁大谁小。
        // 首先，按照name进行比较。
        int temp = this.name.compareTo(o.name);

        // 走到这里的时候，如果name相同（temp=0）, 就按age比
        temp = temp == 0 ? this.age - o.age : temp;

        // 如果到这里，  temp=0 ，说明什么 ==》   name相同，age相同。
        temp = temp == 0 ? this.address.compareTo(o.address) : temp;

        return temp;
    }
}


class Student2 {
    String name;
    int age;
    String phone;

    public Student2(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student2{" + "name='" + name + '\'' + ", age=" + age + ", phone='" + phone + '\'' + '}';
    }
}
