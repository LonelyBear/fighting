package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/22 14:18
 * @description https://leetcode.cn/problems/smallest-even-multiple/ 2413. 最小偶倍数
 */
public class LeetCode2413 {
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }
        return n * 2;
    }
}
