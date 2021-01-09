package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/9 13:33
 * @description https://leetcode-cn.com/problems/fibonacci-number/ 509. 斐波那契数
 */

public class LeetCode509 {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
