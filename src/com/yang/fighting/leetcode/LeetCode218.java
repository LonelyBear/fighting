package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/13 19:48
 * @description https://leetcode-cn.com/problems/the-skyline-problem/ 218. 天际线问题
 */

public class LeetCode218 {
    public List<List<Integer>> getSkyline(int[][] bs) {
        List<int[]> ps = new ArrayList<>();
        // 左边界设置为负的 为了后续判断左右边界
        for (int[] b : bs) {
            ps.add(new int[]{b[0], -b[2]});
            ps.add(new int[]{b[1], b[2]});
        }
        ps.sort((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        priorityQueue.add(0);
        List<List<Integer>> ans = new ArrayList<>();
        int preHeight = 0;
        for (int[] p : ps) {
            if (p[1] < 0) {
                // 左边界 加入观察优先队列
                priorityQueue.add(-p[1]);
            } else {
                // 右边界 排除观察优先队列
                priorityQueue.remove(p[1]);
            }
            int currentHeight = priorityQueue.peek();
            if (currentHeight != preHeight) {
                List<Integer> node = new ArrayList<>();
                node.add(p[0]);
                node.add(currentHeight);
                preHeight = currentHeight;
                ans.add(node);
            }
        }
        return ans;
    }
}
