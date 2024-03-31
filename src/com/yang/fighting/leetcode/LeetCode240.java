package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/10/20 23:07
 * @description
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            int index = search(nums, target);
            if (index > 0) {
                return true;
            }
        }
        return false;
    }

    private int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 +  low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
