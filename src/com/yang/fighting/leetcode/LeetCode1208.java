package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/5 17:43
 * @description https://leetcode-cn.com/problems/get-equal-substrings-within-budget/ 1208. 尽可能使字符串相等
 */
public class LeetCode1208 {

    // 双指针 + 滑动窗口
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] dif = new int[len];
        for (int i = 0; i < len; i++) {
            dif[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0, start = 0, end = 0, sum = 0;
        while (end < len) {
            sum += dif[end];
            while (sum > maxCost) {
                sum -= dif[start++];
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
