package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/8 14:47
 * @description https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class LeetCode122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        List<List<Integer>> spiltAscList = new ArrayList<>();
        int cutIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                int[] tmp = Arrays.copyOfRange(prices, cutIndex, i);
                List<Integer> tmpList = new ArrayList<>();
                for (int num : tmp) {
                    tmpList.add(num);
                }
                spiltAscList.add(tmpList);
                cutIndex = i;
            }
        }
        int[] last = Arrays.copyOfRange(prices, cutIndex, prices.length);
        List<Integer> lastList = new ArrayList<>();
        for (int num : last) {
            lastList.add(num);
        }
        spiltAscList.add(lastList);
        int res = 0;
        for (List<Integer> list : spiltAscList) {
            if (list.size() > 1) {
                res = list.get(list.size() - 1) - list.get(0) + res;
            }
        }
        return res;
    }


}
