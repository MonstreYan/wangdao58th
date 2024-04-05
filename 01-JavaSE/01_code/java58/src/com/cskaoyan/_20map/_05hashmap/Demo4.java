package com.cskaoyan._20map._05hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Common-zhou
 * @since 2024-04-05 14:45
 */
public class Demo4 {

    @Test
    public void test1() {
        // 如果我们在HashMap已经添加了一份key-value数据,
        // 建议尽量不要再通过key的引用直接修改key,  有可能会无法 再操作这个数据 (了解)

        Map<User4, String> map = new HashMap<>();
        User4 zs = new User4("zs", 18);
        map.put(zs, "zhangsan");
        map.put(new User4("ls", 19), "lisi");

        zs.name = "zzzs";
        // 添加流程
        // 1.计算hash值。  （zs 18）会算出一个hashCode。
        // 2.对数组长度进行取余
        // 3.判断该位置有没有数据。

        map.remove(zs);
        /// 1.计算hash值。  （zzzs 18）会算出一个hashCode。

        System.out.println(map);
    }


    @Test
    public void test2() {
        // 删除流程
        HashMap<String, String> map = new HashMap<>();

        map.put("zs", "hubei");

        map.remove("zs");

        String s = map.get("zs");
    }

    @Test
    public void test3() {
        // HashMap(int initialCapacity)
        // 构造一个带指定初始容量和默认加载因子 (0.75) 的空 HashMap。 会找到大于等于当前值的一个2的幂次方

        // 16 2
        // 16 * 2

        HashMap<String, String> objectObjectHashMap = new HashMap<>(17);
    }

    // name  age
    public void test4(Map<String, String> map) {

    }

    public void test4(User4 user4) {

    }

    @Test
    public void test5() {
        Map<String, String> map = new HashMap<>();

        map.put("zs", "hubei");
        map.put("ls", "hunan");
        map.put("wu", "henan");

        System.out.println(map);

    }
}

// Map来模拟User4.
// name   zs
// age 18
// 因为Map太过灵活，写代码非常容易出错。或者说，在有时候，代码不运行起来根本不知道里面有什么数据
class User4 {
    String name;
    int age;

    public User4(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User4{" + "name='" + name + '\'' + ", age=" + age + '}';
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User4 user4 = (User4) object;
        return age == user4.age && Objects.equals(name, user4.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
