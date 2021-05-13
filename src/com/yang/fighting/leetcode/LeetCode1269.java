package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/13 16:23
 * @description https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/ 1269. 停在原地的方案数
 */

public class LeetCode1269 {
    public int numWays(int steps, int arrLen) {
        final int modNum = 1000000007;
        int maxColumn = Math.min(arrLen - 1, steps);
        int[] dp = new int[maxColumn + 1];
        dp[0] = 1;
        for (int i = 0; i < steps; i++) {
            int[] dpTmp = new int[maxColumn + 1];
            for (int j = 0; j <= maxColumn; j++) {
                dpTmp[j] = dp[j];
                if (j - 1 >= 0) {
                    dpTmp[j] = (dpTmp[j] + dp[j - 1]) % modNum;
                }
                if (j + 1 <= maxColumn) {
                    dpTmp[j] = (dpTmp[j] + dp[j + 1]) % modNum;
                }
            }
            dp = dpTmp;
        }
        return dp[0];
    }
}
