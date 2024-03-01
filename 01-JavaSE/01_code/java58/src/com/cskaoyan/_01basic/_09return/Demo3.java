package com.cskaoyan._01basic._09return;

import org.junit.Test;

/**
 * 1.代码要写在方法里面。
 * 2.方法和方法，应该是平齐的。 不要用一个方法，去包裹另一个方法
 *
 * @author Common-zhou
 * @since 2024-03-01 14:30
 */
public class Demo3 {
    // int i= 10;
    // i++;
    // System.out.println(i);


    public static void main(String[] args) {
        // break就是中止循环。
        // continue就是跳出这次循环，下次继续。

        for (int i = 0; i < 100; i++) {
            if (i == 5) {
                break;
            }
        }
    }

    @Test
    public void test1() {

        // 1. 控制台输出2次，"我热爱学习Java"  break  continue
        // 2. 控制台输出7次，"我热爱学习Java"   ===》  continue
        // 3. 控制台输出13次，"我热爱Java"

        // continue
        // break
        // return

        // 1 2 3   10
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                //在此处填写代码
                // continue;
                // break;
                // return;
                System.out.println("我热爱学习Java");
            }
            System.out.println("我热爱学习Java");
        }
    }


}
