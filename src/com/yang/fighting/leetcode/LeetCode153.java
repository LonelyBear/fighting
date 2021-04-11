package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/10 21:39
 * @description https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/ 153. 寻找旋转排序数组中的最小值
 */

public class LeetCode153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
