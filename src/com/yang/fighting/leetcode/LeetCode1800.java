package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/7 10:52
 * @description https://leetcode.cn/problems/maximum-ascending-subarray-sum/ 1800. 最大升序子数组和
 */
public class LeetCode1800 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                tmp += nums[i];
                continue;
            }
            res = Math.max(res, tmp);
            tmp = nums[i];
        }
        res = Math.max(res, tmp);
        return res;
    }
}
