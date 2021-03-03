package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/3 10:55
 * @description https://leetcode-cn.com/problems/range-sum-query-immutable/ 303. 区域和检索 - 数组不可变
 */

public class NumArray {

    private int[] dp;

    public NumArray(int[] nums) {
        init(nums);
    }

    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j] - dp[i - 1];
    }

    private void init(int[] nums) {
        int length = nums.length;
        dp = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i] = nums[0];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
    }
}
