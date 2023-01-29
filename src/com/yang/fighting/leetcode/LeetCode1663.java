package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @date 2023/1/26 12:05
 * @description https://leetcode.cn/problems/smallest-string-with-a-given-numeric-value/ 1663. 具有给定数值的最小字符串
 */
public class LeetCode1663 {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        // 贪心:
        // 先将数组全置为 'a'
        // 然后从后往前尽可能换成最大的字符
        Arrays.fill(ans, 'a');
        int remain = k - n;
        int i = n - 1;
        for (; remain > 25; remain -= 25) {
            ans[i--] = 'z';
        }
        ans[i] += remain;
        return String.valueOf(ans);
    }
}
