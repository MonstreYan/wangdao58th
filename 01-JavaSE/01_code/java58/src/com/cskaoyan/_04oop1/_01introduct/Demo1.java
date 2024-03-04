package com.cskaoyan._04oop1._01introduct;

import org.junit.Test;

/**
 * 张三养了3只狗，一只1岁白色萨摩亚，一只2岁黄白柯基，一只3岁黄色金毛
 * 现在，需要用代码， 把这些数据存起来。
 * 怎么存？
 * 1.思路1： 直接用字符串存。 1岁白色萨摩亚
 * 2岁黄白柯基
 * 3岁黄色金毛
 * 取数据或者修改数据不方便。
 * <p>
 * 2.思路2： 使用单独的变量存储；
 *
 * @author Common-zhou
 * @since 2024-03-04 16:26
 */
public class Demo1 {
    @Test
    public void test1() {
        int dog1Age = 1;
        String dog1Color = "白色";
        String dog1Type = "萨摩耶";

        int dog2Age = 2;
        String dog2Color = "黄白色";
        String dog2Type = "柯基";

        int dog3Age = 3;
        String dog3Color = "黄色";
        String dog3Type = "金毛";

        // 使用这种方式来存储，有什么问题
        // 变量太多，非常容易弄混。  变量是分散的，非常容易出错。
        // 如果，有1000条狗。 取名的工作量非常大。
    }

    @Test
    public void test2(){
        String[] dog1 = {"萨摩耶", "白色", "1"};
        String[] dog2 = {"柯基", "黄白色", "2"};
        String[] dog3 = {"金毛", "黄色", "3"};

        // 可读性不高。 看不出来第0个是什么，第1个是什么。
    }
}
