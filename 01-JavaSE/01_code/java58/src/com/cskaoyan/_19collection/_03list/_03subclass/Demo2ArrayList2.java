package com.cskaoyan._19collection._03list._03subclass;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Common-zhou
 * @since 2024-04-01 16:24
 */
public class Demo2ArrayList2 {
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>(Arrays.asList(19, 17, 6, 8, 84, 24));

        // Comparable
        // Comparator
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list);

        // 看名字，然后挑着用。
        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });

        System.out.println(list);


    }
}
