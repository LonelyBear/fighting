package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/15 10:41
 * @description https://leetcode-cn.com/problems/remove-k-digits/
 */

public class LeetCode402 {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        return null;
    }
}
