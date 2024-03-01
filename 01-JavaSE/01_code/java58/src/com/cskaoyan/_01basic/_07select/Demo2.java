package com.cskaoyan._01basic._07select;

import org.junit.Test;

/**
 * @author Common-zhou
 * @since 2024-03-01 10:24
 */
public class Demo2 {
    public static void main(String[] args) {
        // 在Java中的选择结构，有两个  if  switch


        // if结构。
        // if(condition)
        // condition里面有两种情况：  要么是一个布尔表达式；要么是一个布尔值

        boolean flag = true;
        if (flag) {
            System.out.println("flag为真");
        }

        int age = 18;
        // 布尔表达式： 结果是一个布尔值。 为true
        if (age > 17) {
            System.out.println("年龄大于17岁");
        }

    }

    @Test
    public void testIfElse() {
        // if的双分支结构。 if  else

        int age = 12;

        if (age > 11) {
            System.out.println("年龄大于11");
        } else {
            System.out.println("年龄小于11");
        }

    }
}
