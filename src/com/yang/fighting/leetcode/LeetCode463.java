package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/30 10:44
 * @description https://leetcode-cn.com/problems/island-perimeter/
 */

public class LeetCode463 {

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int Y = grid.length;
        int X = grid[0].length;
        int res = 0;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i - 1 >= 0) {
                        if (grid[i - 1][j] == 1) {
                            res--;
                        }
                    }
                    if (i + 1 < Y) {
                        if (grid[i + 1][j] == 1) {
                            res--;
                        }
                    }
                    if (j - 1 >= 0) {
                        if (grid[i][j - 1] == 1) {
                            res--;
                        }
                    }
                    if (j + 1 < X) {
                        if (grid[i][j + 1] == 1) {
                            res--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
