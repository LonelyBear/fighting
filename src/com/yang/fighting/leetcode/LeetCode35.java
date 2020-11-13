package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/3 16:32
 * @description https://leetcode-cn.com/problems/search-insert-position/
 */

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target == nums[i]) {
                return i;
            }
            if (target > nums[i]) {
                return i + 1;
            }
        }
        return 0;
    }
}
