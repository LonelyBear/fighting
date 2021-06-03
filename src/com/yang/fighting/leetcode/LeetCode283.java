package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/19 10:46
 * @description https://leetcode-cn.com/problems/move-zeroes/ 283. 移动零
 */

public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) {
                    continue;
                }
                nums[i] = nums[j];
                nums[j] = 0;
                break;
            }
        }
    }
}
