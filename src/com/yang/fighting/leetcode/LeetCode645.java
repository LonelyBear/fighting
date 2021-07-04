package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/4 11:10
 * @description https://leetcode-cn.com/problems/set-mismatch/ 645. 错误的集合
 */

public class LeetCode645 {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int repeat = 0;
        int loss = 0;
        int pre = 0;
        boolean findLoss = false;
        if (nums[0] != 1) {
            loss = 1;
            findLoss = true;
        }
        for (int num : nums) {
            if (!findLoss) {
                if (num - pre > 1) {
                    findLoss = true;
                    loss = pre + 1;
                }
            }
            if (num == pre) {
                repeat = pre;
            } else {
                pre = num;
            }
        }
        if (!findLoss) {
            loss = len;
        }
        return new int[]{repeat, loss};
    }
}
