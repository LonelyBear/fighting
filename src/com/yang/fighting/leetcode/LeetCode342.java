package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/31 10:14
 * @description
 */

public class LeetCode342 {
    public boolean isPowerOfFour(int n) {
        int zero = 0, one = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                one++;
            } else {
                zero++;
            }
            n = n >> 1;
        }
        return zero % 2 == 0 && one == 1;
    }
}
