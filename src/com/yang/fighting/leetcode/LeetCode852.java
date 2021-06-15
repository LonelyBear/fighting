package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/15 17:43
 * @description https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/ 852. 山脉数组的峰顶索引
 */

public class LeetCode852 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left != right) {
            if (arr[left] < arr[left + 1]) {
                left++;
            }
            if (arr[right] < arr[right - 1]) {
                right--;
            }
        }
        return left;
    }
}
