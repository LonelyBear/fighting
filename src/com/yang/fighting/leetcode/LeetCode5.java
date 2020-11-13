package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/27 14:17
 * @description https://leetcode-cn.com/problems/longest-palindromic-substring/
 */

public class LeetCode5 {
    public String longestPalindrome(String s) {
        return dpMethod(s);
    }

    /**
     * 中心扩展法
     *
     * @param s
     * @return
     */
    private String centerExpandMethod(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * 动态规划法
     *
     * @param s
     * @return
     */
    private String dpMethod(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        String res = "";
        for (int step = 0; step < size; step++) {
            for (int i = 0; i + step < size; i++) {
                int j = i + step;
                if (step == 0) {
                    dp[i][j] = true;
                } else if (step == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                if (dp[i][j] && (step + 1 > res.length())) {
                    res = s.substring(i, i + step + 1);
                }
            }
        }
        return res;
    }

}
