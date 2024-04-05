package com.cskaoyan._20map._05hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Common-zhou
 * @since 2024-04-05 10:16
 */
public class Demo3 {
    @Test
    public void test1() {
        // HashMap的添加流程

        // Map<String, String> map = new HashMap<>();
        HashMap<String, String> map = new HashMap<>();

        map.put("zhangsan", "hubei");
        map.put("lisi", "hunan");
        map.put("wangwu", "beijing");
        map.put("jingtian", "henan");
    }

    @Test
    public void test2() {
        // 自定义的类，作为HashMap的key， 一定要同时重写 hashCode和equals方法

        Map<User3, String> map = new HashMap<>();

        map.put(new User3("zs", 18), "zhangsan");
        map.put(new User3("ls", 18), "lisi");
        map.put(new User3("zs", 18), "zhangsan123123");

        // HashMap里面，怎样认为key是相同的？
        System.out.println(map);

        // 在HashMap中，要作为key。 一定要同时重写hashCode和equals方法。
        // case1: 只重写了hashCode.equals没重写。 有几个数据； 三个
        // case2: 只重写equals。不重写hashCode。三个
        // case3: 重写equals。重写hashCode。两个
    }


    @Test
    public void test3() {
        Map<User3, String> map = new HashMap<>();

        User3 zs = new User3("zs", 18);
        map.put(zs, "zhangsan");
        map.put(new User3("ls", 18), "lisi");
        map.put(zs, "zhangsan123123");

        System.out.println(map);

        // 不建议大家使用自定义的类当做key。一般使用字符串或者Integer。
    }

    @Test
    public void test4() {
        // HashMap中怎样认为是重复的
        // 这个步骤，在添加数据的时候，需要用到这个代码。

        // p是什么东西。p是该位置，数组的数据（节点）
        // hash   key  value

        // 要判断，是否相等。
        // 第一步，直接比较int值。（和key的hashCode相关。 ）
        // int值相同
        // 第二步。左边为true或者右边为true。 都认为true。
        // 左边： (k = p.key) == key 地址相同。
        // 右边： (key != null && key.equals(k))： equals方法相同，
        // if (p.hash == hash &&
        //                 ((k = p.key) == key || (key != null && key.equals(k))))


        // 总结一下。 HashMap中，怎样认为是相同的
        // 1.hashCode一定要相同。
        // 2.要么是同一个地址； 要么是equals方法。
    }

}


class User3 {
    private String name;
    private int age;

    public User3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User3{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    // @Override
    // public boolean equals(Object object) {
    //     if (this == object) return true;
    //     if (object == null || getClass() != object.getClass()) return false;
    //     User3 user3 = (User3) object;
    //     return age == user3.age && Objects.equals(name, user3.name);
    // }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
