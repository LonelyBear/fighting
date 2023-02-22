package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/22 21:38
 * @description https://leetcode.cn/problems/stone-game-ii/ 1140. 石子游戏 II
 */
public class LeetCode1140 {
    public int stoneGameII(int[] piles) {
        // https://leetcode.cn/problems/stone-game-ii/solution/java-dong-tai-gui-hua-qing-xi-yi-dong-17xing-by-lg/
        // 惊为天人的dp解法
        int len = piles.length, rightSum = 0;
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            rightSum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = rightSum;
                } else {
                    for (int j = 1; j <= 2 * M; j++) {
                        dp[i][M] = Math.max(dp[i][M], rightSum - dp[i + j][Math.max(M, j)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
