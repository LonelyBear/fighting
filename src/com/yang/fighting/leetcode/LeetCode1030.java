package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/17 11:37
 * @description https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 */

public class LeetCode1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        if (R == 0 && C == 0) {
            return new int[0][0];
        }
        int[][] res = new int[R * C][2];
        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[count][0] = i;
                res[count][1] = j;
                count++;
            }
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(calcDistance(o1[0], o1[1], r0, c0), calcDistance(o2[0], o2[1], r0, c0));
            }
        });
        return res;
    }

    private int calcDistance(int pointX, int pointY, int x0, int y0) {
        return Math.abs(pointX - x0) + Math.abs(pointY - y0);
    }
}
