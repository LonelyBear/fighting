package com.yang.fighting.sort;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/27 16:32
 * @description 希尔排序 - 缩小增量排序
 */

public class ShellSort {

    public static int[] shellSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int temp, gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }

        return array;
    }


    public static void main(String[] args) {
        shellSort(new int[]{2, 4, 13, 5, 1, 6});
    }
}
