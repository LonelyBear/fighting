package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/6 20:32
 * @description https://leetcode-cn.com/problems/next-greater-element-ii/ 503. 下一个更大元素 II
 */

public class LeetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        // 单调栈保存位置索引 遍历 len + len - 1 的拼接数组
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len + len - 1; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i % len]) {
                res[deque.pop()] = nums[i % len];
            }
            deque.push(i % len);
        }
        return res;
    }
}
