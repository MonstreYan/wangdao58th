package com.cskaoyan._19collection._02collection._05example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 删除湖北的学生。
 *
 * @author Common-zhou
 * @since 2024-03-29 17:37
 */
public class Demo6 {
    @Test
    public void test1() {
        // 1.iterator

        Collection<Student6> collection = new ArrayList<>();

        // 要删除4个。
        collection.add(new Student6("zs", 18, "hubei"));
        collection.add(new Student6("ls", 18, "hunan"));
        collection.add(new Student6("wu", 18, "hubei"));
        collection.add(new Student6("zs", 18, "guangxi"));
        collection.add(new Student6("zl", 18, "hubei"));
        collection.add(new Student6("zs", 18, "beijing"));
        collection.add(new Student6("zs", 18, "hubei"));
        collection.add(new Student6("jingtian", 18, "shanxi"));


        Iterator<Student6> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Student6 student6 = iterator.next();

            // if (student6.getAddress().equals("hubei")){
            if ("hubei".equals(student6.getAddress())) {
                iterator.remove();
            }
        }

        System.out.println(collection);
        System.out.println(collection.size());

    }


    @Test
    public void test2() {
        Collection<Student6> collection = new ArrayList<>();

        // 要删除4个。
        collection.add(new Student6("zs", 18, "hubei"));
        collection.add(new Student6("ls", 18, "hunan"));
        collection.add(new Student6("wu", 18, "hubei"));
        collection.add(new Student6("zs", 18, "guangxi"));
        collection.add(new Student6("zl", 18, "hubei"));
        collection.add(new Student6("zs", 18, "beijing"));
        collection.add(new Student6("zs", 18, "hubei"));
        collection.add(new Student6("jingtian", 18, "shanxi"));


        Collection<Student6> needRemovedStudentCollection = new ArrayList<>();
        for (Student6 student6 : collection) {
            if ("hubei".equals(student6.getAddress())) {
                // collection.remove(student6);
                needRemovedStudentCollection.add(student6);
            }
        }

        // needRemovedStudentCollection
        // collection.removeAll(needRemovedStudentCollection);
        // System.out.println(collection.size());

    }


    @Test
    public void test3() {
        // 比如要删除湖北的学生

        // 1.迭代器。   iterator.remove();
        // 2.用一个新的，来装不是湖北的。
        // 3.用一个新的，来装湖北的， 装完之后。   removeAll(). remove()
        Collection<Student6> collection = new ArrayList<>();

        // 要删除4个。
        collection.add(new Student6("zs", 18, "hubei"));
        collection.add(new Student6("ls", 18, "hunan"));
        collection.add(new Student6("wu", 18, "hubei"));
        collection.add(new Student6("zs", 18, "guangxi"));
        collection.add(new Student6("zl", 18, "hubei"));
        collection.add(new Student6("zs", 18, "beijing"));
        collection.add(new Student6("zs", 18, "hubei"));
        collection.add(new Student6("jingtian", 18, "shanxi"));

        Collection<Student6> needRemovedStudentCollection = new ArrayList<>();
        for (Student6 student6 : collection) {
            if ("hubei".equals(student6.getAddress())) {
                needRemovedStudentCollection.add(student6);
            }
        }

        for (Student6 student6 : needRemovedStudentCollection) {
            collection.remove(student6);
        }

    }


    public static void main(String[] args) {
        Collection<Student6> collection = new ArrayList<>();

        // 要删除4个。
        collection.add(new Student6("zs", 18, "hubei"));
        collection.add(new Student6("ls", 18, "hunan"));
        collection.add(new Student6("wu", 18, "hubei"));
        collection.add(new Student6("zs", 18, "guangxi"));
        collection.add(new Student6("zl", 18, "hubei"));
        collection.add(new Student6("zs", 18, "beijing"));
        collection.add(new Student6("zs", 18, "hubei"));
        collection.add(new Student6("jingtian", 18, "shanxi"));

        testRemoveHubeiStudent(collection);

        System.out.println(collection);
    }

    public static void testRemoveHubeiStudent(Collection<Student6> collection) {
        Collection<Student6> notHubeiStudent = new ArrayList<>();
        for (Student6 student6 : collection) {
            if (!"hubei".equals(student6.getAddress())) {
                // collection.remove(student6);
                notHubeiStudent.add(student6);
            }
        }

        collection = notHubeiStudent;
    }
}

class Student6 {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public Student6 setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student6 setAge(int age) {
        this.age = age;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Student6 setAddress(String address) {
        this.address = address;
        return this;
    }

    public Student6(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student6{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }


}
