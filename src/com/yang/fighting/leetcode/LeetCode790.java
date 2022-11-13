package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/13 21:03
 * @description https://leetcode.cn/problems/domino-and-tromino-tiling/submissions/ 790. 多米诺和托米诺平铺
 */
public class LeetCode790 {
    public int numTilings(int n) {
        int MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 2][4];
        dp[1][0] = dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1];
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum = (sum + dp[i - 1][j]) % MOD;
            }
            dp[i][1] = sum;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][3]) % MOD;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
        }
        return dp[n][1];
    }
}
