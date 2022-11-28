package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/19 15:49
 * @description https://leetcode.cn/problems/global-and-local-inversions/ 775. 全局倒置与局部倒置
 */
public class LeetCode775 {
    // 单调增栈 和 多比较间隔一个数的前缀最大值
    public boolean isIdealPermutation(int[] nums) {
        if (nums.length == 1 || nums.length == 2) {
            return true;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int tmp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i >= 2) {
                if (nums[i] < tmp) {
                    return false;
                } else {
                    tmp = Math.max(tmp, nums[i - 1]);
                }
            }
            if (stack.isEmpty()) {
                stack.addLast(i);
                continue;
            }
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                int idx = stack.pollLast();
                if (i - idx > 1) {
                    return false;
                }
            }
            stack.addLast(i);
        }
        return true;
    }
}
