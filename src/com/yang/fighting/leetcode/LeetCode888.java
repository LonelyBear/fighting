package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/1 10:09
 * @description https://leetcode-cn.com/problems/fair-candy-swap/ 888. 公平的糖果棒交换
 */

public class LeetCode888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        int[] dpB = new int[100001];
        for (int num : A) {
            sumA += num;
        }
        for (int num : B) {
            sumB += num;
            dpB[num]++;
        }
        int delta = (sumB - sumA) / 2;
        for (int j : A) {
            int expectB = j + delta;
            if (expectB <= 0 || expectB > 100000) {
                continue;
            }
            if (dpB[expectB] != 0) {
                return new int[]{j, expectB};
            }
        }
        return null;
    }
}
