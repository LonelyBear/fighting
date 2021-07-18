package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/16 09:51
 * @description https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/ 1846. 减小和重新排列数组后的最大元素
 */

public class LeetCode1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int ans = 1;
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
            ans = Math.max(arr[i], ans);
        }
        return ans;
    }
}
