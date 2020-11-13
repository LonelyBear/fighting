package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/27 17:57
 * @description https://leetcode-cn.com/problems/uncrossed-lines/
 * 1035. 不相交的线
 */

public class LeetCode1035 {

    public int maxUncrossedLines(int[] A, int[] B) {
        int sizeA = A.length, sizeB = B.length;
        int[][] dp = new int[sizeA + 1][sizeB + 1];
        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[sizeA][sizeB];
    }
}
