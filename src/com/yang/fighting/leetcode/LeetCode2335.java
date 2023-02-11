package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/11 19:42
 * @description https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/ 2335. 装满杯子需要的最短总时长
 */
public class LeetCode2335 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int count = 0;
        int zeroCnt = 0;
        for (int j : amount) {
            if (j == 0) {
                zeroCnt++;
            }
        }
        while (zeroCnt < 3) {
            for (int i = 2; i > 0; i--) {
                if (amount[i] == 1) {
                    zeroCnt++;
                }
                if (amount[i] > 0) {
                    amount[i]--;
                }
            }
            count++;
            Arrays.sort(amount);
        }
        return count;
    }
}
