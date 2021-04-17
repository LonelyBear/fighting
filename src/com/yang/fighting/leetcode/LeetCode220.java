package com.yang.fighting.leetcode;

import java.util.TreeSet;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/17 11:52
 * @description https://leetcode-cn.com/problems/contains-duplicate-iii/ 220. 存在重复元素 III
 */

public class LeetCode220  {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Long ceil = treeSet.ceiling((long)nums[i] - (long) t);
            if (ceil != null && (long) nums[i] + t >= ceil) {
                return true;
            }
            treeSet.add((long) nums[i]);
            if (i >= k) {
               treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
