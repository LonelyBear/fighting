package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/6/1 20:12
 * @description https://leetcode-cn.com/problems/reverse-integer/
 */

public class LeetCode7 {
    public int reverse(int x) {
        long y = (long) x;
        boolean sign = y >= 0;
        Long[] tmp1 = new Long[32];
        if (y < 0) {
            y = -y;
        }
        int count = 0;
        do {
            tmp1[count] = y % 10;
            count++;
            y = y / 10;
        } while (y > 0);
        long res = 0;
        for (int i = 0; i <= tmp1.length - 1; i++) {
            if (tmp1[i] != null) {
                res = res * 10 + tmp1[i];
            }
        }
        res = sign ? res : -res;
        if (res > (long) Math.pow(2, 31) - 1 || res < -(long) Math.pow(2, 31)) {
            return 0;
        }
        return (int) res;
    }

}
