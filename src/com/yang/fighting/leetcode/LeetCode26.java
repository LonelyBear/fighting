package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/30 23:14
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */

public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[res]) {
                res++;
                nums[res] = nums[i];
            }
        }
        return res + 1;
    }
}
