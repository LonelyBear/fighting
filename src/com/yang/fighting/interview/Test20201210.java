package com.yang.fighting.interview;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/10 18:55
 * @description
 */
public class Test20201210 {
    public boolean find(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        boolean up = nums[nums.length - 1] > nums[0];
        int left = 0;
        int right = nums.length;
        int mid = (left + right) / 2;
        while (left < right) {
            if (nums[mid] == target) {
                return true;
            }
            if (up) {
                if (nums[mid] > target){
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] > target){
                    left = mid;
                } else {
                    right = mid;
                }
            }
            mid = (left + right) / 2;
        }
        return false;
    }
}
