package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/6 15:49
 * @description https://leetcode-cn.com/problems/ones-and-zeroes/ 474. 一和零
 */

public class LeetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < len; i++) {
            int[] res = getOneZero(strs[i]);
            int one = res[0], zero = res[1];
            for(int j = m; j >= zero; j--) {
                for(int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] getOneZero(String str) {
        int[] res = new int[2];
        if (str.length() == 0) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        for(char c : str.toCharArray()) {
            if(c == '1') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }
}
