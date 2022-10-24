package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/24 22:26
 * @description https://leetcode.cn/problems/partition-array-into-disjoint-intervals/ 915. 分割数组
 */
public class LeetCode915 {
    public int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] minArray = new int[len + 1];
        minArray[len] = Integer.MAX_VALUE;
        // 经典模拟
        // 左数组的最大值 <= 右数组的最小值
        // 先遍历一遍找到最小值的数组 [i, len-1]
        // 在从左向右进行遍历
        for (int i = len - 1; i >= 0; i--) {
            minArray[i] = Math.min(minArray[i + 1], nums[i]);
        }
        int max = -1;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(nums[i], max);
            if (max <= minArray[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }
}
