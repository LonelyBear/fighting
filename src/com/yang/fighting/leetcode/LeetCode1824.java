package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @date 2023/1/21 11:40
 * @description https://leetcode.cn/problems/minimum-sideway-jumps/ 1824. 最少侧跳次数
 */
public class LeetCode1824 {
    public int minSideJumps(int[] obstacles) {
        // dynamic programming
        int[] dp = new int[3];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 1; i <= obstacles.length - 1; i++) {
            int minCnt = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (j == obstacles[i] - 1) {
                    dp[j] = Integer.MAX_VALUE;
                } else {
                    minCnt = Math.min(minCnt, dp[j]);
                }
            }
            for (int j = 0; j < 3; j++) {
                if (j != obstacles[i] - 1) {
                    dp[j] = Math.min(minCnt + 1, dp[j]);
                }
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
