package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/15 16:06
 * @description https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?favorite=2cktkvj 121. 买卖股票的最佳时机
 */
public class LeetCode121 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= minPrice) {
                result = Math.max(result, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }
        return result;
    }
}
