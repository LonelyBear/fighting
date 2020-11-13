package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/27 21:09
 * @description https://leetcode-cn.com/problems/longest-common-subsequence/
 * 1143. 最长公共子序列
 * 画格子理解
 */

public class LeetCode1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int size1 = text1.length();
        int size2 = text2.length();
        int[][] dp = new int[size1 + 1][size2 + 1];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[size1][size2];
    }
}
