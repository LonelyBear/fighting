package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/6 17:00
 * @description https://leetcode-cn.com/problems/maximum-subarray/
 */

public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sumData = 0;
        int res = nums[0];
        for (int num : nums) {
            sumData = Math.max(sumData + num, num);
            res = Math.max(sumData, res);
        }
        return res;
    }
}
