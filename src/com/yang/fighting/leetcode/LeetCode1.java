package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/5/29 19:41
 * @description https://leetcode-cn.com/problems/two-sum/
 */

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = 0;
        while (true) {
            for (int i = left + 1; i < nums.length; i++) {
                if (nums[left] + nums[i] == target) {
                    right = i;
                    res[0] = left;
                    res[1] = right;
                    return res;
                }
            }
            left++;
            if (left >= nums.length) break;
        }
        res[0] = left;
        res[1] = right;
        return res;
    }
}
