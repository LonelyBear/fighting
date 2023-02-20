package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/16 21:08
 * @description https://leetcode.cn/problems/longest-well-performing-interval/ 1124. 表现良好的最长时间段
 */
public class LeetCode1124 {
    public int longestWPI(int[] hours) {
        int ans = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                ans = Math.max(ans, i + 1);
            } else if (map.containsKey(sum - 1)) {
                ans = Math.max(ans, i - map.get(sum - 1));
            }
            map.putIfAbsent(sum, i);
        }
        return ans;
    }
}
