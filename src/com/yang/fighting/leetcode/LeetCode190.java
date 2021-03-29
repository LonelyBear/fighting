package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/29 09:56
 * @description https://leetcode-cn.com/problems/reverse-bits/ 190. 颠倒二进制位
 */

public class LeetCode190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] arrays = new int[32];
        int index = 0;
        if (n < 0) {
            arrays[0] = 1;
            n = 2147483647 + n + 1;
        }
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                arrays[31 - i] = 1;
            }
            n = n >> 1;
        }
        int res = 0;
        for (int i = 0; i < 31; i++) {
            res = arrays[i] * (int) Math.pow(2, i) + res;
        }
        if (arrays[31] == 0) {
            return res;
        }
        return -2147483648 + res;
    }
}
