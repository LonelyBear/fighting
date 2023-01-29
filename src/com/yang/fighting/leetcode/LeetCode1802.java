package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @date 2023/1/18 12:05
 * @description https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/ 1802. 有界数组中指定下标处的最大值
 */
public class LeetCode1802 {
    public int maxValue(int arraySize, int index, int maxSum) {
        // 二分查找到满足的最大和
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (valid(mid, arraySize, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean valid(int mid, int arraySize, int index, long maxSum) {
        if (mid == 1) {
            return true;
        }
        maxSum = maxSum - arraySize;
        mid--;
        int left = Math.max(0, index - (mid - 1));
        int right = Math.min(arraySize - 1, index + (mid - 1));
        return calc(left, index, mid) + calc(index, right, mid) - mid <= maxSum;
    }

    private long calc(int left, int right, long val) {
        return ((val - (right - left)) + val) * (right - left + 1) / 2;
    }


}
