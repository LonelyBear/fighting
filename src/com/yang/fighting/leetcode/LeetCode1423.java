package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/6 20:29
 * @description https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/ 1423. 可获得的最大点数
 */

public class LeetCode1423 {

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        // 求卡牌点数最大, 相当于求滑动窗口数 len - k 的最小
        int windowSize = len - k;
        int sum = 0, minSum = Integer.MAX_VALUE, total = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
            total += cardPoints[i];
        }
        minSum = sum;
        for (int i = windowSize; i < len; i++) {
            sum -= cardPoints[i - windowSize];
            sum += cardPoints[i];
            total += cardPoints[i];
            minSum = Math.min(sum, minSum);
        }
        return total - minSum;
    }
}
