package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/16 10:27
 * @description https://leetcode-cn.com/problems/spiral-matrix-ii/ 59. 螺旋矩阵 II
 */

public class LeetCode59 {

    private int[][] res;

    public int[][] generateMatrix(int n) {
        res = new int[n][n];
        process(n, 0, 0, 1);
        return res;
    }

    private void process(int size, int X, int Y, int current) {
        if (size < 1) {
            return;
        }
        if (size == 1) {
            res[X][Y] = current;
            return;
        }
        for (int i = 0; i < size; i++) {
            res[X][Y + i] = current;
            current++;
        }
        for (int i = 1; i < size; i++) {
            res[X + i][Y + size - 1] = current;
            current++;
        }
        for (int i = 1; i < size; i++) {
            res[X + size - 1][Y + size - 1 - i] = current;
            current++;
        }
        for (int i = 1; i < size - 1; i++) {
            res[X + size - 1 - i][Y] = current;
            current++;
        }
        process(size - 2, X + 1, Y + 1, current);
    }
}
