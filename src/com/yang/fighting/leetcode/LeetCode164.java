package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/26 12:40
 * @description
 */

public class LeetCode164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.max(res, nums[i + 1] - nums[i]);
        }
        return res;
    }
}
