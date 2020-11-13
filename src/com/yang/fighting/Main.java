package com.yang.fighting;

import com.yang.fighting.sort.QuickSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        QuickSort quickSort = new QuickSort();
        int[] res = new int[]{5, 1, 7, 3, 1, 6, 9, 4};
        quickSort.quickSort(res, 0, 7);
        System.out.println(Arrays.toString(res));
    }
}
