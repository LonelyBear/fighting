package com.yang.fighting.leetcode;

import java.util.TreeSet;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/1 10:22
 * @description https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class Leetcode34 {

    TreeSet<Integer> treeSet;

    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }
        treeSet = new TreeSet<>();
        mergeRange(nums, 0, nums.length - 1, target);
        if (treeSet.isEmpty()) {
            return res;
        }
        res[0] = treeSet.first();
        res[1] = treeSet.last();
        return res;
    }

    private void mergeRange(int[] nums, int left, int right, int target) {
        if (left >= right) {
            if (nums[left] == target) {
                treeSet.add(left);
            }
            return;
        }
        if (nums[left] > target || nums[right] < target) {
            return;
        }
        int mid = (left + right) / 2;
        mergeRange(nums, left, mid, target);
        mergeRange(nums, mid + 1, right, target);
    }
}
