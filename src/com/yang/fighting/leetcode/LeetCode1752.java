package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/27 16:00
 * @description https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/ 1752. 检查数组是否经排序和轮转得到
 */
public class LeetCode1752 {
    public boolean check(int[] nums) {
        int cnt = 0, curMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ) {
            int j = i;
            while (j + 1 < nums.length && nums[j] <= nums[j + 1]) {
                if (nums[j + 1] > curMin) {
                    return false;
                }
                j += 1;
            }
            if (nums[j] > curMin) {
                return false;
            }
            curMin = Math.min(nums[i], curMin);
            cnt++;
            i = j + 1;
        }
        return cnt <= 2;
    }
}
