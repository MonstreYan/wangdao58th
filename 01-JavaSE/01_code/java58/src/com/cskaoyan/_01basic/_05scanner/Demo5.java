package com.cskaoyan._01basic._05scanner;

import org.junit.Test;

/**
 * 有没有什么办法，能让我在这一个里面，近似的多写几个主方法。
 *
 * 1.加一个 @Test注解。
 * @Test
 * public void test1(){
 *     // 在这里面去写逻辑
 * }
 * 2.如果Test是红色的， 这时候，alt + enter然后导包。
 *
 * @author Common-zhou
 * @Test
 * @since 2024-03-01 10:03
 */
public class Demo5 {
    public static void main(String[] args) {
        System.out.println("main 方法");
    }


    // 先这样写。
    // 注意1： 写了@Test之后。是个红色的。 在@Test的旁边， 点击alt + enter
    //  add junit4 .
    // 如果成功，后续 Test就会变成正常颜色。 然后旁边会出现一个按钮，可以点击，之后运行该方法
    @Test
    public void test1() {
        System.out.println("test 方法");
    }

    @Test
    public void test2() {
        System.out.println("test2 放");
    }
}
