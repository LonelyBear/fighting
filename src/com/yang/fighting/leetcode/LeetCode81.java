package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/10 15:47
 * @description https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/ 81. 搜索旋转排序数组 II
 */

public class LeetCode81 {

    public boolean search(int[] nums, int target) {
        if (nums[0] > target) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (target == nums[i]) {
                    return true;
                }
                if (nums[i] < target) {
                    return false;
                }
                if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    return true;
                }
                if (nums[i] > target) {
                    return false;
                }
                if (i + 1 < nums.length && nums[i + 1] < nums[i]){
                    return false;
                }
            }
        }
        return false;
    }
}
