package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/26 18:07
 * @description https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/ 795. 区间子数组个数
 */
public class LeetCode795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 以右端点遍历
        // 记录之前最后一个符合的位置
        int result = 0, lastUp = -1, lastIn = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                lastIn = i;
            } else if (nums[i] > left) {
                lastUp = i;
                lastIn = -1;
            }
            if (lastIn != -1) {
                result += lastIn - lastUp;
            }
        }
        return result;
    }
}
