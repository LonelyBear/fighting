package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/3 16:53
 * @description https://leetcode-cn.com/problems/maximum-ice-cream-bars/ 1833. 雪糕的最大数量
 */

public class LeetCode1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        int index = 0;
        while (coins > 0 && index < costs.length) {
            if (coins >= costs[index]) {
                result++;
                coins -= costs[index];
            } else {
                coins -= costs[index];
            }
            index++;
        }
        return result;
    }
}
