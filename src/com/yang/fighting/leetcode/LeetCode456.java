package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/24 13:00
 * @description https://leetcode-cn.com/problems/132-pattern/ 456. 132模式
 */

public class LeetCode456 {
    public boolean find132pattern(int[] nums) {
        // 维护一个数组, 为当前数左边最小的数
        int len = nums.length;
        int[] leftMinArray = new int[len];
        leftMinArray[0] = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            leftMinArray[i] = Math.min(nums[i - 1], leftMinArray[i - 1]);
        }
        // 维护一个单调递减栈, 从右向左遍历找到当前数 和 右边比它小的最大的数
        Deque<Integer> stack = new LinkedList<>();
        for (int i = len - 1; i > 0; i--) {
            int current = nums[i];
            int currentRight = Integer.MIN_VALUE;
            while (!stack.isEmpty() && stack.peek() < current) {
                currentRight = stack.pop();
            }
            stack.push(current);
            if (leftMinArray[i] < currentRight) {
                return true;
            }
        }
        return false;
    }
}
