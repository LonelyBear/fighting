package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/28 20:40
 * @description https://leetcode.cn/problems/sum-of-subarray-minimums/ 907. 子数组的最小值之和
 */
public class LeetCode907 {
    public int sumSubarrayMins(int[] arr) {
        // 单调栈
        int len = arr.length;
        int[] leftIndexArray = new int[len], rightIndexArray = new int[len];
        Arrays.fill(leftIndexArray, -1);
        Arrays.fill(rightIndexArray, len);
        Deque<Integer> stack = new ArrayDeque<>();
        // 找到右边比当前元素小于等于的
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peekLast()] >= arr[i]) {
                rightIndexArray[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        stack.clear();
        // 左边
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                leftIndexArray[stack.pollLast()] = i;
            }
            stack.addLast(i);
        }
        int result =  0;
        int MOD = (int)1e9+7;
        for (int i = 0; i < len; i++) {
            result += ((long) (i - leftIndexArray[i]) * (rightIndexArray[i] - i)) % MOD * arr[i] % MOD;
            result %= MOD;
        }
        return result;
    }
}
