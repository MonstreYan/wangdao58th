package com.cskaoyan._18generic.d07_interface;

import org.junit.Test;

import java.util.Date;

/**
 * 写一个接口： 主要的作用，是转换器接口。 将一种数据类型转换到另外一种数据类型。
 * "123"  ===>  123
 * 454534244  ===> Date
 *
 * 泛型，就是为了提升类型的灵活性。
 *
 * @author Common-zhou
 * @since 2024-03-28 10:57
 */
public class Demo4Ex {
    @Test
    public void test1() {
        // 后续，我们见到这个接口。 Converter
        Converter<String, Integer> converter = new String2IntegerConverter();

        System.out.println("converter.convert(\"123\") = " + converter.convert("123"));

        // 把运行期的问题，提前到了编译期发现。
        // converter.convert(12345);

        Long2DateConverter long2DateConverter = new Long2DateConverter();
        Date date = long2DateConverter.convert(System.currentTimeMillis());

        System.out.println(date);

    }
}

// 泛型的作用： 就是让类型灵活可变。
interface Converter<E, R> {
    R convert(E element);
}

// "123"  ===>  123
// 在这种转换器的接口里面。我们希望1、能够看出来是什么转成什么类型； 2、希望看出来这是个什么接口。
// 类型2类型接口名
class String2IntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String element) {
        // 1.见到这个接口。别人就知道是转换器。  规范。
        // 2.可以在这里面做一些业务逻辑，统一一些异常。

        // try {
        //     Integer.parseInt(element);
        // } catch (NumberFormatException e) {
        //     throw new RuntimeException(e);
        // }

        return Integer.parseInt(element);
    }
}


// 454534244  ===> Date
class Long2DateConverter implements Converter<Long, Date> {

    @Override
    public Date convert(Long element) {
        return new Date(element);
    }
}

// String2Date   "2024-03-28 11:09:00"
