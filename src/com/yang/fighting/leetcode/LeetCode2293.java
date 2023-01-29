package com.yang.fighting.leetcode;

import java.util.function.Function;

/**
 * @author yangtao
 * @date 2023/1/23 18:07
 * @description https://leetcode.cn/problems/min-max-game/ 2293. 极大极小游戏
 */
public class LeetCode2293 {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        while (len > 1) {
            for (int i = 0; i < len / 2; i++) {
                if (i % 2 == 0) {
                    nums[i] = Math.min(nums[i * 2], nums[i * 2 + 1]);
                } else {
                    nums[i] = Math.max(nums[i * 2], nums[i * 2 + 1]);
                }
            }
            len = len / 2;
        }
        return nums[0];
    }

}
