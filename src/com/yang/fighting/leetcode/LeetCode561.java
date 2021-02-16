package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/16 10:54
 * @description https://leetcode-cn.com/problems/array-partition-i/ 561. 数组拆分 I
 */

public class LeetCode561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                res += nums[i];
            }
        }
        return res;
    }
}
