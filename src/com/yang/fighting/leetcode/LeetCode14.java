package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/28 18:04
 * @description https://leetcode-cn.com/problems/longest-common-prefix/
 */

public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = findCommonPrefix(res, strs[i]);
        }
        return res;
    }

    private String findCommonPrefix(String s1, String s2) {
        int index = 0;
        while (index < Math.min(s1.length(), s2.length())) {
            if (s1.charAt(index) != s2.charAt(index)) {
                break;
            }
            index++;
        }
        return s1.substring(0, index);
    }
}
