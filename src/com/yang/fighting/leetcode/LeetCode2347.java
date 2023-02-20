package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/20 21:11
 * @description https://leetcode.cn/problems/best-poker-hand/ 2347. 最好的扑克手牌
 */
public class LeetCode2347 {
    public String bestHand(int[] ranks, char[] suits) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map1.merge(suits[i], 1, Integer::sum);
            map2.merge(ranks[i], 1, Integer::sum);
        }
        if (map1.size() == 1) {
            return "Flush";
        }
        String ans = null;
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == 2) {
                ans =  "Pair";
            }
            if (entry.getValue() >= 3) {
                ans =  "Three of a Kind";
                break;
            }
        }
        if (ans != null) {
            return ans;
        }
        if (map2.size() == 5) {
            return "High Card";
        }
        return null;
    }
}
