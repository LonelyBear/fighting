package com.yang.fighting.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/2 12:49
 * @description https://leetcode-cn.com/problems/sliding-window-maximum/ 239. 滑动窗口最大值
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 这块最巧妙的就是把角标存了下来,在poll的时候可以根据角标判断 o(1)操作 而不是最初的直接remove, remove操作可能时间很久
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        int index = 0;
        res[index++] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            res[index++] = queue.peek()[0];
        }
        return res;
    }
}
