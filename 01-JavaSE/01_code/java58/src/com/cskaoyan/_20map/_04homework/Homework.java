package com.cskaoyan._20map._04homework;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数, 返回它们的索引。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 比如：nums = [2, 7, 11, 15], target = 9.
 * 因为 nums[0] + nums[1] = 2 + 7 = 9. 所以返回 [0, 1].
 *
 * @author Common-zhou
 * @since 2024-04-03 10:14
 */
public class Homework {
    @Test
    public void test1() {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // 时间复杂度  n^2
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + "___" + j);
                }
            }

        }


    }


    @Test
    public void test2() {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // 使用Map来实现。
        // 使用Map，就要思考，key是什么东西，value是什么东西

        // key是数组里面的值； value是下标；

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 对于 i号位置来说。我期望找到  target - num
            Integer otherIndex = map.get(target - num);
            if (otherIndex != null) {
                // 找到了。 结果就是
                break;
            }
            map.put(num, i);
        }
    }
}
