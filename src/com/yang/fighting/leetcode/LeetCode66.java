package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/12 20:30
 * @description https://leetcode-cn.com/problems/plus-one/
 */

public class LeetCode66 {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[0];
        }
        boolean up = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                if (digits[i] + 1 > 9) {
                    digits[i] = 0;
                    up = true;
                } else {
                    digits[i] = digits[i] + 1;
                    break;
                }
            } else {
                if (up) {
                    if (digits[i] + 1 > 9) {
                        digits[i] = 0;
                        up = true;
                    } else {
                        digits[i] = digits[i] + 1;
                        up = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        if (up) {
            int[] digitsNew = new int[digits.length + 1];
            for (int i = 0; i < digitsNew.length; i++) {
                if (i == 0) {
                    digitsNew[i] = 1;
                } else {
                    digitsNew[i] = digits[i - 1];
                }
            }
            return digitsNew;
        }
        return digits;
    }
}
