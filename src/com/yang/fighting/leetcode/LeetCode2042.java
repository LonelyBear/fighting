package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @date 2023/1/18 10:53
 * @description https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/ 2042. 检查句子中的数字是否递增
 */
public class LeetCode2042 {
    public boolean areNumbersAscending(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        String[] array = s.split(" ");
        int lastNum = Integer.MIN_VALUE;
        for (String s1 : array) {
            if (isNumber(s1)) {
                if (Integer.parseInt(s1) <= lastNum) {
                    return false;
                } else {
                    lastNum = Integer.parseInt(s1);
                }
            }
        }
        return true;
    }

    private boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
