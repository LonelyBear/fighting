package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/27 14:58
 * @description https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/  674. 最长连续递增序列
 */
public class LeetCode674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
