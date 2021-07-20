package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/19 10:41
 * @description https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/ 1838. 最高频元素的频数
 */

public class LeetCode1838 {


    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        // 前缀和数组 len + 1 第一项为0
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        // 二分滑动窗口的长度
        int left = 0, right = len;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(mid, len, preSum, nums, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    /**
     * 滑动窗口判断是否符合 条件
     *
     * @param midLen
     * @param len
     * @param preSum
     * @return
     */
    private boolean check(int midLen, int len, int[] preSum, int[] nums, int k) {
        for (int left = 0; left + midLen - 1 < len; left++) {
            int right = left + midLen - 1;
            int curSum = preSum[right + 1] - preSum[left];
            int targetSum = nums[right] * midLen;
            if (targetSum - curSum <= k) {
                return true;
            }
        }
        return false;
    }
}
