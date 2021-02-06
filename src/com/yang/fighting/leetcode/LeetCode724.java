package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/29 11:39
 * @description https://leetcode-cn.com/problems/find-pivot-index/ 724. 寻找数组的中心索引
 */

public class LeetCode724 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int leftSum = 0;
        int rightSum = 0;
        for (int num : nums) {
            rightSum = rightSum + num;
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i];
            leftSum = i == 0 ? 0 : leftSum + nums[i - 1];
            if (rightSum == leftSum) {
                return i;
            }
        }
        return -1;
    }
}
