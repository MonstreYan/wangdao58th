package com.cskaoyan._10exception._03throws;

/**
 * throw关键字，可以帮助我们在代码中，手动抛出一个异常
 *
 * 如果手动抛出了异常，这种有什么用。
 * 异常这一节的作用：在工作过程中，我们有一些场景，必须要使用异常来表示，
 * 比如读文件读不到。比如除了一个0. 这种场景必须使用异常。
 *  告诉别人，代码在这跑不下去了。要么你告诉我怎么搞。要么我代码就不跑了。
 *
 * @author Common-zhou
 * @since 2024-03-19 11:53
 */
public class Demo2Throw {

    public static void main(String[] args) {


        //  跟的是一个具体的异常对象。
        throw new RuntimeException("Demo2 Throw main method");

    }
}
