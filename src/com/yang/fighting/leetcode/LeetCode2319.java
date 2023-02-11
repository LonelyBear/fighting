package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/1/31 21:08
 * @description https://leetcode.cn/problems/check-if-matrix-is-x-matrix/ 2319. 判断矩阵是否是一个 X 矩阵
 */
public class LeetCode2319 {
    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val = grid[i][j];
                if (isSpecial(i, j, grid.length)) {
                    if (val == 0) {
                        return false;
                    }
                } else {
                    if (val != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isSpecial(int i, int j, int len) {
        if (i == j) {
            return true;
        }
        return i + j == len - 1;
    }
}
