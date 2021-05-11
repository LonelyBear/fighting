package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/7 14:14
 * @description https://leetcode-cn.com/problems/xor-operation-in-an-array/ 1486. 数组异或操作
 */

public class LeetCode1486 {
    public int xorOperation(int n, int start) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (start + 2 * i) ^ res;
        }
        return res;
    }
}
