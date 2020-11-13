package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/30 15:20
 * @description https://leetcode-cn.com/problems/string-to-integer-atoi/
 */

public class LeetCode8 {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean begin = false;
        boolean sign = true;
        for (int i = 0; i < s.length(); i++) {
            if (!begin) {
                if (!((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '-' || s.charAt(i) == ' ' || s.charAt(i) == '+')) {
                    return 0;
                }
                if (s.charAt(i) != ' ') {
                    begin = true;
                }
                if (s.charAt(i) == '-') {
                    sign = false;
                }
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    stringBuilder.append(s.charAt(i));
                }
            } else {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    stringBuilder.append(s.charAt(i));
                } else {
                    break;
                }
            }
        }
        String newS = stringBuilder.toString();
        if (newS.length() == 0) {
            return 0;
        }
        long res = 0L;
        for (int i = 0; i < newS.length(); i++) {
            res = res * 10L + (long) (newS.charAt(i) - '0');
            if (res > (long) Integer.MAX_VALUE) {
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        res = sign ? res : -res;
        if (res > (long) Math.pow(2, 31) - 1) {
            return Integer.MAX_VALUE;
        }
        if (res < -(long) Math.pow(2, 31)) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }
}
