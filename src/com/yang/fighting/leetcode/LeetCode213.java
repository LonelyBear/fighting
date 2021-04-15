package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/15 11:10
 * @description https://leetcode-cn.com/problems/house-robber-ii/ 213. 打家劫舍 II
 */

public class LeetCode213 {

    private int s1,s2,f1,f2;


    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0] , Math.max(nums[2], nums[1]));
        }
        f1 = nums[0];
        s1 = Math.max(nums[0], nums[1]);
        f2 = nums[1];
        s2 = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length; i++) {
            if (i == 2) {
                dp(1, nums[i]);
                continue;
            }
            if (i == nums.length - 1) {
                dp(2, nums[i]);
                continue;
            }
            dp(1, nums[i]);
            dp(2, nums[i]);
        }
        return Math.max(s1, s2);
    }

    private void dp(int type, int value) {
        int tmp;
        if (type == 1) {
            tmp = s1;
            s1 = Math.max(f1 + value, s1);
            f1 = tmp;
        } else {
            tmp = s2;
            s2 = Math.max(f2 + value, s2);
            f2 = tmp;
        }
    }
}
