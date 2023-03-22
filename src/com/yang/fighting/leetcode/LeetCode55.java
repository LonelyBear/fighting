package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/20 21:10
 * @description https://leetcode.cn/problems/jump-game/?favorite=2cktkvj 55. 跳跃游戏
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        boolean[] result = new boolean[nums.length];
        int target = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (target < i) {
                return false;
            }
            if (nums[i] > 0) {
                target = Math.max(target, nums[i] + i);
            }
        }
        return target >= nums.length - 1;
    }
}
