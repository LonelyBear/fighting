package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/12 10:40
 * @description https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/ 剑指 Offer 59 - I. 滑动窗口的最大值
 */

public class SwordOffer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int len = nums.length;
        // 维护一个单调递减的队列, 存放数组的对应索引
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[len - k + 1];
        int i = 0;
        while (i < len) {
            // 先去掉范围以外的数
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }
            // 再比对当前值 形成单调减队列
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peek()];
            }
            i++;
        }
        return res;
    }
}
