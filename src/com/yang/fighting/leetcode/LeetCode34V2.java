package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/20 20:30
 * @description https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/ 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode34V2 {
    // 二分查找的典型应用
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target - 1);
        int right = binarySearch(nums, target) - 1;
        if (left <= right && nums[left] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    // 找到大于target的下标
    // 二分查找的细节: 如果要大于某值 直接left+1,
    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid, ans = nums.length;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
