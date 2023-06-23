package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/6/23 16:55
 * @description https://leetcode.cn/problems/maximum-value-of-a-string-in-an-array/ 2496. 数组中字符串的最大值1
 */
public class LeetCode2496 {
    public int maximumValue(String[] strs) {
        int ans = 0;
        boolean isNum;
        for (String str : strs) {
            char[] array = str.toCharArray();
            isNum = true;
            for (char c : array) {
                if (c >= 'a' && c <= 'z') {
                    isNum = false;
                    break;
                }
            }
            if (isNum) {
                ans = Math.max(ans, Integer.parseInt(str));
            } else {
                ans = Math.max(ans, str.length());
            }
        }
        return ans;
    }
}
