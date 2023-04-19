package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/19 23:41
 * @description https://leetcode.cn/problems/partition-array-for-maximum-sum/ 1043. 分隔数组以得到最大和
 */
public class LeetCode1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int maxVal = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                dp[i] = Math.max(dp[i], dp[j] + maxVal * (i - j));
                if (j > 0) {
                    maxVal = Math.max(maxVal, arr[j - 1]);
                }
            }
        }
        return dp[len];
    }
}
