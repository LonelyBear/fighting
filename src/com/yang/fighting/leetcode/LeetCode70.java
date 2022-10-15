package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/15 15:20
 * @description https://leetcode.cn/problems/climbing-stairs/?favorite=2cktkvj 70. 爬楼梯
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
