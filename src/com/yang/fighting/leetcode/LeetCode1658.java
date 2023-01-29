package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @date 2023/1/20 09:47
 * @description https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/ 1658. 将 x 减到 0 的最小操作数
 */
public class LeetCode1658 {
    public int minOperations(int[] nums, int target) {
        int len = nums.length;
        int arraySum = Arrays.stream(nums).sum();
        if (arraySum < target) {
            return -1;
        }
        int left = -1, right = 0, leftSum = 0, rightSum = arraySum, result = len + 1;
        // 滑动窗口
        for (; left < len; left++) {
            if (left >= 0) {
                leftSum += nums[left];
            }
            while (right < len && leftSum + rightSum > target) {
                rightSum -= nums[right];
                right++;
            }
            if (rightSum + leftSum == target) {
                result = Math.min(result, (left + 1) + (len - right));
            }
        }
        return result > len ? -1 : result;
    }
}
