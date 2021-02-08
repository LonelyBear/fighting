package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/8 12:50
 * @description https://leetcode-cn.com/problems/longest-turbulent-subarray/ 978. 最长湍流子数组
 */

public class LeetCode978 {

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        int len = arr.length;
        // 二维数组sp, 分别存储最后一位为升或降的最大位数
        int[][] dp = new int[2][len];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[0][i] = dp[1][i - 1] + 1;
                max = Math.max(dp[0][i], max);
            }
            if (arr[i] < arr[i - 1]) {
                dp[1][i] = dp[0][i - 1] + 1;
                max = Math.max(dp[1][i], max);
            }
        }
        return max + 1;
    }
}
