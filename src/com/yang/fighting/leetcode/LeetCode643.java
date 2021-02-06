package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/4 14:32
 * @description https://leetcode-cn.com/problems/maximum-average-subarray-i/ 643. 子数组最大平均数 I
 */

public class LeetCode643 {
    public double findMaxAverage(int[] nums, int k) {
        int maxValue = 0;
        int sum = 0;
        int i = 0;
        for (; i < k; i++) {
            sum += nums[i];
        }
        maxValue = sum;
        for (; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxValue = Math.max(sum, maxValue);
        }
        return (double) maxValue / (double) k ;
    }
}
