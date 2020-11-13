package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/10 10:25
 * @description https://leetcode-cn.com/problems/next-permutation/
 */

public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 1) {
            return;
        }
        int left = 0, right = 0;
        // 找到交换的数字
        boolean first = true;
        for (int i = nums.length - 1; i > 0; i--) {
            int leftTmp = 0, rightTmp = 0;
            for (int j = i - 1; j >=0 ; j--) {
                if (nums[i] > nums[j]) {
                    leftTmp = j;
                    rightTmp = i;
                    break;
                }
            }
            if (first) {
                if (leftTmp != rightTmp) {
                    left = leftTmp;
                    right = rightTmp;
                    first = false;
                }
            } else {
                if (leftTmp > left) {
                    left = leftTmp;
                    right = rightTmp;
                } else if (leftTmp == left && nums[rightTmp] <= nums[right] ) {
                    right = rightTmp;
                }
            }
        }
        // left == right 说明没找到,则直接顺序排序
        if (left == right) {
            Arrays.sort(nums);
            return;
        }

        // [0, left - 1] 不动
        // nums[left] swap nums[right]
        // [left + 1, nums.length - 1] sort
        int num = nums[left];
        nums[left] = nums[right];
        nums[right] = num;
        int[] tmp = Arrays.copyOfRange(nums, left + 1, nums.length);
        Arrays.sort(tmp);
        for (int i = 0; i < tmp.length; i++) {
            nums[left + 1 + i] = tmp[i];
        }
         System.out.println(Arrays.toString(nums));
    }
}
