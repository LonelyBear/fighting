package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/11 11:07
 * @description https://leetcode-cn.com/problems/ugly-number-ii/    264. 丑数 II
 */

public class LeetCode264 {
    public int nthUglyNumber(int n) {
        int[] params = new int[]{2, 3, 5};
        // 使用long型防止溢出
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> numSet = new HashSet<>();
        numSet.add(1L);
        heap.offer(1L);
        int res = 0;
        for (int i = 0; i < n; i++) {
            long cur = heap.poll();
            // System.out.print(cur);
            res = (int) cur;
            for (int num : params) {
                long toDo = num * cur;
                if (!numSet.contains(toDo)) {
                    heap.offer(toDo);
                    numSet.add(toDo);
                }
            }
        }
        return res;
    }
}
