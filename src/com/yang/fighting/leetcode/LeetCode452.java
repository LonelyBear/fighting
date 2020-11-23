package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/23 13:02
 * @description https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        // 贪心算法, 找数组的右端点进行排序遍历
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int res = 1;
        int arrow = points[0][1];
        for (int[] balloon : points) {
            if (balloon[0] > arrow) {
                res++;
                arrow = balloon[1];
            }
        }
        return res;
    }
}
