package com.cskaoyan._19collection._06set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Common-zhou
 * @since 2024-04-05 17:08
 */
public class Demo2Set2 {
    @Test
    public void test1() {
        // 1.  有些子实现无序(HashSet),  有些子实现是有序的(LinkedHashSet, TreeSet大小有序)
        // 2.  所有子实现都不允许存储重复元素（什么叫重复。 HashSet或者LinkedHashSet  hashCode相同& equals 为true   TreeSet是Comparable接口返回0，叫重复。）
        // 3.  有些子实现允许存储null(HashSet, LinkedHashSet), 有些子实现不允许存储null(TreeSet)

        // Set<String> set = new HashSet<>();
        // Set<String> set = new LinkedHashSet<>();
        Set<String> set = new TreeSet<>();

        set.add("zs");
        set.add("ls");
        set.add("wu");
        set.add("zs");
        System.out.println(set);

    }

    @Test
    public void test2() {
        Set<String> set = new HashSet<>();

        set.add("zs");
        set.add("ls");
        set.add("zs");
        System.out.println(set);

        Set<User2> set1 = new HashSet<>();
        set1.add(new User2("zs", 18));
        set1.add(new User2("ls", 18));
        set1.add(new User2("zs", 18));

        System.out.println(set1);
    }
}

class User2 {
    String name;
    int age;

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User2 user2 = (User2) object;
        return age == user2.age && Objects.equals(name, user2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
