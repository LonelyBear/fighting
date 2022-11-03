package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/3 09:22
 * @description https://leetcode.cn/problems/maximum-repeating-substring/ 1668. 最大重复子字符串
 */
public class LeetCode1668 {
    public int maxRepeating(String sequence, String word) {
        int sLen = sequence.length(), wLen = word.length();
        int[] dp = new int[sLen + 1];
        int result = 0;
        for (int i = 1; i <= sLen; i++) {
            if (i < wLen) continue;
            if (sequence.substring(i - wLen, i).equals(word)) {
                dp[i] = dp[i - wLen] + 1;
                result = Math.max(dp[i], result);
            }
        }
        return result;
    }
}
