package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/20 15:48
 * @description https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/ 1877. 数组中最大数对和的最小值
 */

public class LeetCode1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            ans = Math.max(nums[i] + nums[nums.length - 1 - i], ans);
        }
        return ans;
    }
}
