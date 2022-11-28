package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/19 15:43
 * @description https://leetcode.cn/problems/find-the-highest-altitude/ 1732. 找到最高海拔
 */
public class LeetCode1732 {
    public int largestAltitude(int[] gain) {
        int result = 0, cur = 0;
        for (int g : gain) {
            cur += g;
            result = Math.max(cur, result);
        }
        return result;
    }
}
