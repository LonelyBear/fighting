package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/31 23:44
 * @description https://leetcode-cn.com/problems/implement-strstr/submissions/
 */

public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
