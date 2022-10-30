package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/29 19:56
 * @description https://leetcode.cn/problems/trapping-rain-water/ 42. 接雨水
 */
public class LeetCode42 {
    public int trap(int[] height) {
        int result = 0;
        // 单调递减栈 维护 索引位次
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 0;
        while (cur < height.length) {
            while (!stack.isEmpty() && height[stack.peekLast()] < height[cur]) {
                int h = height[stack.pollLast()];
                if (stack.isEmpty()) {
                    break;
                }
                int LeftIndex = stack.peekLast();
                result += (cur - LeftIndex - 1) * (Math.min(height[cur], height[LeftIndex]) - h);
            }
            stack.addLast(cur++);
        }
        return result;
    }

}
