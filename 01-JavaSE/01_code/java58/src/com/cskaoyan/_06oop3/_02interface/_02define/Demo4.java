package com.cskaoyan._06oop3._02interface._02define;

/**
 * 1.接口是什么东西？（先大后小）
 * 它是一个结构体，里面可以定义抽象方法，而且方法默认都是抽象的
 * [访问权限修饰符] interface 接口名{
 * // 在这里面定义的方法，默认都是 public  abstract
 * }
 * <p>
 * 接口名：  大驼峰。有的时候，一些程序员，喜欢在前面加上 I
 *
 * @author Common-zhou
 * @since 2024-03-12 10:55
 */
public class Demo4 {
    public static void main(String[] args) {
        IConverter iConverter = new String2IntConverter();

        int num = iConverter.convert("123");
        System.out.println(num);
    }
}


// 转换器接口。主要的工作就是转换。
// 把字符串，转换为 int 。 接口怎么写？
interface IConverter {
    int convert(String s);
}

// "123"  -->  123
// Integer.parseInt();
// 实现类的命名：  String2IntConverter
// 转换器实现类。  从什么类型，转换到什么类型。 转换器接口名在后面
class String2IntConverter implements IConverter {

    @Override
    public int convert(String s) {
        return Integer.parseInt(s);
    }
}

