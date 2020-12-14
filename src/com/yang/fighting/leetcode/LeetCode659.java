package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/4 20:33
 * @description https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 */

public class LeetCode659 {
    public boolean isPossible(int[] nums) {
        // java 优先队列 PriorityQueue 的应用
        if (nums.length < 3) {
            return false;
        }
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            if (map.containsKey(num - 1)) {
                int minLength = map.get(num - 1).poll();
                if (map.get(num - 1).size() == 0) {
                    map.remove(num - 1);
                }
                map.get(num).offer(minLength + 1);
            } else {
                map.get(num).offer(1);
            }
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
