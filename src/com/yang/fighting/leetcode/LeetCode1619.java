package com.yang.fighting.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yangtao
 * @date 2022/9/14 19:46
 * @description https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 */
public class LeetCode1619 {
    public double trimMean(int[] arr) {
        int arrLen = arr.length;
        int threshold = (arrLen * 5) / 100;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int sum = 0;
        for (int num : arr) {
            sum += num;
            pq1.add(num);
            pq2.add(num);
        }
        for (int i = 0; i < threshold; i++) {
            sum -= pq1.poll();
            sum -= pq2.poll();
            arrLen -= 2;
        }
        return (double) sum / (double) arrLen;
    }
}
