package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/4 21:22
 * @description https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 */
public class LeetCode2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        res[i][j] = Math.max(res[i][j], grid[x][y]);
                    }
                }
            }
        }
        return res;
    }

}
