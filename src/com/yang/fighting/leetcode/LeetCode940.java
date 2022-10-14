package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/14 23:20
 * @description https://leetcode.cn/problems/distinct-subsequences-ii/ 940. 不同的子序列 II
 */
public class LeetCode940 {
    public int distinctSubseqII(String s) {
        long mod = 1000000007;
        long[] charCntArray = new long[26];
        for (char c : s.toCharArray()) {
            long sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += charCntArray[i] % mod;
            }
            charCntArray[c - 'a'] = sum + 1;
        }
        long result = 0;
        for (int i = 0; i < 26; i++) {
            result += charCntArray[i];
        }
        return (int) (result % mod);
    }
}
