package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/15 09:00
 * @description https://leetcode-cn.com/problems/max-consecutive-ones/ 485. 最大连续1的个数
 */

public class LeetCode485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return len;
        }
        int left = 0, right = 0, maxSize = 0;
        while (right < len) {
            if (nums[right] == 1) {
                while (nums[left] != 1 && left <= right) {
                    left++;
                }
                if (nums[left] == 1) {
                    maxSize = Math.max(maxSize, right - left + 1);
                }
            } else {
                left = right;
            }
            right++;
        }
        return maxSize;
    }
}
