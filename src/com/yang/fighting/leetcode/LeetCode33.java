package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/6 20:21
 * @description https://leetcode.cn/problems/search-in-rotated-sorted-array/?favorite=2cktkvj 33. 搜索旋转排序数组
 */
public class LeetCode33 {
    // 二分查找的变形版本
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int left = 0, right = len - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
