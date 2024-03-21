package com.cskaoyan._12io._03otherstream;

import org.junit.Test;

import java.io.*;

/**
 * @author Common-zhou
 * @since 2024-03-21 16:11
 */
public class Demo4 {
    @Test
    public void test1WriteObject() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("222.txt"));

        User4 zs = new User4("zs", 18);
        // {name="zs", age=18}

        // ObjectOutputStream可以将一个对象，序列化（把对象，变成二进制数据存起来）.
        // 有一个要求： 一定要实现 Serializable 接口
        objectOutputStream.writeObject(zs);

        objectOutputStream.close();
    }


    @Test
    public void test2() throws IOException, ClassNotFoundException {
        // 通过Java的序列化流，写出去的对象，人只能看懂一点。有的看不懂。
        // 必须通过反序列化流，将其读进来，才能看懂

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("222.txt"));

        // o我们知道，是一个User4对象
        Object o = objectInputStream.readObject();

        User4 user4 = (User4) o;

        System.out.println(user4.name);
        System.out.println(user4.age);

        // 反序列化，就是从文件中。把序列化之后的数据。读入内存，然后变成一个对象的过程。
    }


    @Test
    public void test3() throws IOException, ClassNotFoundException {
        // 关于报错的问问题。

        // serialVersionUID 是Java在序列化和反序列中，用来校验的。(做双保险的)
        // 用来校验是否是同一个对象。
        // Java需要确定，你当时序列化的时候，用的哪个类。 现在反序列化的时候。我也得用这个类。

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("222.txt"));

        Object o = objectInputStream.readObject();

        User4 user4 = (User4) o;

        System.out.println(user4.name);
        System.out.println(user4.age);

        System.out.println(o);


    }
}

class User4 implements Serializable {
    // @Serial
    // private static final long serialVersionUID = 5612199967298922969L;
    @Serial
    private static final long serialVersionUID = -8656582347360103657L;
    String name;
    int age;
    transient String password;

    public User4(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "User4{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

