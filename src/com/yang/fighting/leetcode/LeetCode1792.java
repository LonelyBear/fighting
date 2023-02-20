package com.yang.fighting.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/19 19:10
 * @description https://leetcode.cn/problems/maximum-average-pass-ratio/ 1792. 最大平均通过率
 */
public class LeetCode1792 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 用优先队列维护增量的最大值
        PriorityQueue<double[]> pq = new PriorityQueue<>((o1, o2) -> {
            double o1Res = (o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1];
            double o2Res = (o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1];
            return Double.compare(o2Res, o1Res);
        });
        for (int[] ele : classes) {
            pq.offer(new double[] {ele[0], ele[1]});
        }
        while (extraStudents > 0) {
            extraStudents--;
            double[] val = pq.poll();
            assert val != null;
            pq.offer(new double[]{val[0] + 1, val[1] + 1});
        }
        double result = 0d;
        while (!pq.isEmpty()) {
            double[] val = pq.poll();
            result += val[0] / val[1];
        }
        return result / classes.length;
    }
}
