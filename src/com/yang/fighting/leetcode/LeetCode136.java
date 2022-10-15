package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/15 16:31
 * @description https://leetcode.cn/problems/single-number/?favorite=2cktkvj 136. 只出现一次的数字
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
