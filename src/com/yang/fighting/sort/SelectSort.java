package com.yang.fighting.sort;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/21 11:50
 * @description 选择排序
 */

public class SelectSort {
    public static int[] selectSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[minIndex];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }
}
