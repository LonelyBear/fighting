package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/22 18:51
 * @description https://leetcode-cn.com/problems/number-of-1-bits/ 191. 位1的个数
 */

public class LeetCode191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int input;
        if (n < 0) {
            count++;
            input = 2147483647 + n + 1;
        } else {
            input = n;
        }
        for (int i = 0; i < 32; i++) {
            if ((input & 1) == 1) {
                count++;
            }
            input = (input) >> 1;
        }
        return count;
    }
}
