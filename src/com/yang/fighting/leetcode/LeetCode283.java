package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/19 10:46
 * @description https://leetcode-cn.com/problems/move-zeroes/ 283. 移动零
 */

public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
            }
            right++;
        }
    }
}
