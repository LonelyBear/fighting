package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/2 20:38
 * @description https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/ 1039. 多边形三角剖分的最低得分
 */
public class LeetCode1039 {
    public int minScoreTriangulation(int[] values) {
        int len = values.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = -1;
            }
        }

        return dps(values, dp, 0, len - 1);
    }

    private int dps(int[] values, int[][] dp, int start, int end) {
        if (Math.abs(start - end) <= 1) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            res = Math.min(res,
                    dps(values, dp, start, i)
                            + dps(values, dp, i, end)
                            + values[start] * values[end] * values[i]);
        }
        dp[start][end] = res;
        return res;
    }
}
