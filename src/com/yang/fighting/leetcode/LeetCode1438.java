package com.yang.fighting.leetcode;

import java.util.TreeMap;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/21 14:49
 * @description https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * 1438. 绝对差不超过限制的最长连续子数组
 */

public class LeetCode1438 {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        int left = 0, right = 0, res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < len) {
            map.merge(nums[right], 1, Integer::sum);
            while (!checkIfBelongLimit(map, limit)) {
                if (map.get(nums[left]) == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], map.get(nums[left]) - 1);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    private boolean checkIfBelongLimit(TreeMap<Integer, Integer> map, int limit) {
        return Math.abs(map.firstKey() - map.lastKey()) <= limit;
    }
}
