package com.cskaoyan._05oop2._01encapsulate;

/**
 * 封装的实现步骤：
 * 1.将变量私有化。   访问权限修饰符写成private
 * 2.对外提供set方法。   name setName(String name)   age   setAge()
 * 3.对外提供get方法。   name   getName()     age  getAge()
 *
 * get方法和set方法，写法非常固定，所以idea提供了自动生成的功能。
 *
 *
 *
 * @author Common-zhou
 * @since 2024-03-08 14:40
 */
public class Demo2 {
    public static void main(String[] args) {
        Student2 student2 = new Student2();
    }
}

class Student2 {

    // 有三个变量。   id   name   age

    private String id;
    private String name;
    private int age;

    public void setName(String name) {
        // this.name  当前的对象的name属性。
        // name 就是我们传入的参数。
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getId() {
        // id this.id
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
