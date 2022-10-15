package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/5/29 19:41
 * @description https://leetcode-cn.com/problems/two-sum/
 */

public class LeetCode1 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
