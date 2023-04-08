package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/7 22:35
 * @description https://leetcode.cn/problems/moving-stones-until-consecutive-ii/ 1040. 移动石子直到连续 II
 */
public class LeetCode1040 {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length;
        int maxResult = (stones[len - 1] - stones[0] + 1 - len)
                - Math.min(stones[1] - stones[0] - 1, stones[len - 1] - stones[len - 2] - 1);
        int minResult = maxResult;
        for (int i = 0; i < len; i++) {
            int j = i;
            while (j < len && stones[j] - stones[i] < len) {
                j++;
            }
            int tmp = len - (j - i);
            if (j - i == len - 1 && stones[j - 1] - stones[i] == len - 2) {
                tmp = 2;
            }
            minResult = Math.min(minResult, tmp);
        }
        return new int[] {minResult, maxResult};
    }
}
