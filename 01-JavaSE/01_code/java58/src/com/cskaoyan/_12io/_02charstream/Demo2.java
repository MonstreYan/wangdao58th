package com.cskaoyan._12io._02charstream;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Common-zhou
 * @since 2024-03-21 11:22
 */
public class Demo2 {
    @Test
    public void test1() throws UnsupportedEncodingException {
        // 在Java中，如何进行编解码。

        // 编码： 'a' ---》  数。  把人能看懂的东西，转换为计算机能看懂的东西
        // 解码： 把计算机能看懂的东西，转换为人能看懂的东西

        // 如何编码。把人能看懂的，转换为计算机能看懂的（数）
        String s = "今晚9点，攻打平安县城";

        byte[] bytes = s.getBytes("UTF-8");

        System.out.println(Arrays.toString(bytes));

        // 如何解码:  new String 将字节数组，转换为字符串。
        String s1 = new String(bytes);

        System.out.println(s1);
    }


    @Test
    public void test2() throws UnsupportedEncodingException {
        // 什么叫乱码。乱码的本质是什么。

        // 密码本。

        // 今晚9点，攻打平安县城
        // [-28, -69, -118, -26, -103, -102, 57, -25, -126, -71, -17, -68, -116, -26, -108, -69, -26, -119, -109, -27, -71, -77, -27, -82, -119, -27, -114, -65, -27, -97, -114]

        // 用之前的密码本，来解析现在的密码本，能不能出来这些信息。
        // 张说是可靠了电话非常贱看下啊会放到科技大厦福晶科技肯定会撒娇
        // 乱码的本质就是： 编解码不一致。
        // 编码用UTF-8.解码用GBK


        String s = "今晚9点，攻打平安县城";

        byte[] bytes = s.getBytes("UTF-8");

        // String s1 = new String(bytes, "UTF-8");
        String s1 = new String(bytes, "GBK");
        System.out.println(s1);

        // 今晚9点，攻打平安县城
        // 浠婃櫄9鐐癸紝鏀绘墦骞冲畨鍘垮煄

        // 编码： 把字，变成一个数字。 解码： 把数字，变成字符。

        // 编解码，不一致，会造成乱码。
        // 怎么解决乱码？ ===》 让编解码一致。


        // ==========================================
        // 今后，凡是遇到乱码，都是编解码不一致。 解决方法，是让编解码一致。  用UTF8编，就用UTF8解、


    }


}
