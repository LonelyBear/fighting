package com.yang.fighting.sort;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/13 12:52
 * @description 快速排序
 */

public class QuickSort {

    /**
     * 快速排序方法
     *
     * @param array
     * @return
     */
    public static int[] quickSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        sort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 迭代方法
     *
     * @param array
     * @param start
     * @param end
     */
    public static void sort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        // 左右指针 + 基准值
        int base = array[start];
        int left = start, right = end;
        while (left < right) {
            // 从右找到一个小于等于基准值的位置
            while (left < right && array[right] >= base) {
                right--;
            }
            // 从左找到一个大于等于基准值的位置
            while (left < right && array[left] <= base) {
                left++;
            }
            if (left < right) {
                swap(array, left, right);
            }
        }
        // 如果 left >= right 表明一次遍历结束
        // 将基准值放在中间
        array[start] = array[left];
        array[left] = base;
        // 继续分治迭代
        sort(array, start, left - 1);
        sort(array, left + 1, end);
    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{2, 4, 13, 5, 1, 6})));
    }
}
