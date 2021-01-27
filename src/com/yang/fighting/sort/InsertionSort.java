package com.yang.fighting.sort;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/21 14:44
 * @description 插入排序
 */
public class InsertionSort {
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            temp = array[i + 1];
            int index = i;
            while (index >= 0 && temp < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        insertionSort(new int[] {2 ,4, 13, 5, 1, 6});
    }
}
