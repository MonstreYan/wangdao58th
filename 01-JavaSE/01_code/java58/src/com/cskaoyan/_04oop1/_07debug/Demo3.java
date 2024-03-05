package com.cskaoyan._04oop1._07debug;

/**
 * prompt: 我先锻炼自己的debug能力。所以我需要你帮我写一个代码，有bug。不要加任何注释。
 * 代码使用Java语言来写。 代码尽量长。
 * 比如： 传入一个学生分数数组，计算超过60分的人数。计算平均分。
 *
 * @author Common-zhou
 * @since 2024-03-05 17:41
 */
public class Demo3 {

    public static void main(String[] args) {

        // 冒泡。

        int[] arr = {5, 1, 4, 2, 8};
        bubbleSort(arr);
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // 在工作过程中，不会写排序。
        // Arrays.sort();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}



