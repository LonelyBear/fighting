package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/9 12:36
 * @description https://leetcode.cn/problems/sum-of-absolute-differences-in-a-sorted-array/ 1685. 有序数组中差绝对值之和
 */
public class LeetCode1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] prefixArray = new int[len];
        prefixArray[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefixArray[i] = prefixArray[i - 1] + nums[i];
        }
        int[] ans = new int[len];
        ans[0] = (prefixArray[len - 1] - prefixArray[0]) - (len - 1) * nums[0];
        ans[len - 1] = (len - 1) * nums[len - 1] - prefixArray[len - 2];
        for (int i = 1; i < len - 1; i++) {
            ans[i] = (i * nums[i]) - (prefixArray[i - 1])
                    + (prefixArray[len - 1] - prefixArray[i]) - (len - 1 - i) * nums[i];
        }
        return ans;
    }
}
