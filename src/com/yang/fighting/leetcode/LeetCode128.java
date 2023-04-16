package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/16 21:17
 * @description https://leetcode.cn/problems/longest-consecutive-sequence/ 128. 最长连续序列
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int ans = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int cur = num;
                while (numSet.contains(cur + 1)) {
                    cur++;
                }
                ans = Math.max(ans, cur - num + 1);
            }
        }
        return ans;
    }
}
