package com.yang.fighting.sort;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/13 12:52
 * @description 快速排序
 */

public class QuickSort {

    /**
     * 快速排序的迭代式
     *
     * @param array
     * @param leftStart
     * @param rightStart
     */
    public void quickSort(int[] array, int leftStart, int rightStart) {
        if (leftStart >= rightStart) {
            return;
        }
        // 左右哨兵
        int left = leftStart;
        int right = rightStart;
        // 基准值
        int key = array[left];
        while (left < right) {
            while (right > left && array[right] >= key) {
                right--;
            }
            array[left] = array[right];
            while (right > left && array[left] <= key) {
                left++;
            }
            array[left] = array[right];
            // 把 left == right 的位置设置为基准值
            array[left] = key;
            // 递归排序
            quickSort(array, leftStart, left - 1);
            quickSort(array, left + 1, rightStart);
        }
    }
}
