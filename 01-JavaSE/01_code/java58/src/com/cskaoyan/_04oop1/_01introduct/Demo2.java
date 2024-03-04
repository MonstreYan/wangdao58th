package com.cskaoyan._04oop1._01introduct;

import org.junit.Test;

/**
 * 张三养了3只狗，一只1岁白色萨摩亚，一只2岁黄白柯基，一只3岁黄色金毛
 * <p>
 * 如果用面向对象的思路。 怎样存储这些信息呢
 *
 * @author Common-zhou
 * @since 2024-03-04 16:33
 */
public class Demo2 {

    @Test
    public void test1() {
        // 怎么使用类，来模拟这个事情。
        // 现在，这个数据。都被存储到 dog1  这里面去了。  有什么好处呢
        Dog dog1 = new Dog();
        dog1.age = 1;
        dog1.color = "白色";
        dog1.type = "萨摩耶";

        Dog dog2 = new Dog();
        dog2.age = 2;
        dog2.color = "黄白色";
        dog2.type = "柯基";

        Dog dog3 = new Dog();
        dog3.age = 3;
        dog3.color = "黄色";
        dog3.type = "金毛";


    }
}

class Dog {
    public int age;
    public String color;
    public String type;


}
