package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/6 21:49
 * @description
 */
public class LeetCode1017 {
    public String baseNeg2(int n) {
        if (n <= 1) {
            return String.valueOf(n);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            int r = n % (-2);
            stringBuilder.append(Math.abs(r));
            if (r >= 0) {
                n = n / (-2);
            } else {
                n = n / (-2) + 1;
            }
        }
        return stringBuilder.reverse().toString();
    }
}
