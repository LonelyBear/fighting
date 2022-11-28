package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/20 12:10
 * @description https://leetcode.cn/problems/champagne-tower/ 799. 香槟塔
 */
public class LeetCode799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 5][query_row + 5];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] <= 1) {
                    continue;
                }
                dp[i + 1][j] += (dp[i][j] - 1) / 2;
                dp[i + 1][j + 1] += (dp[i][j] - 1) / 2;
            }
        }
        return Math.min(dp[query_row][query_glass], 1);
    }
}
