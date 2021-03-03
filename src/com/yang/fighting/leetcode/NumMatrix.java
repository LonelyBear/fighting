package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/3 16:26
 * @description https://leetcode-cn.com/problems/range-sum-query-2d-immutable/ 304. 二维区域和检索 - 矩阵不可变
 */

public class NumMatrix {

    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        int column = matrix.length;
        if (column == 0) return;
        int row = matrix[0].length;
        dp = new int[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += col1 == 0 ? dp[i][col2] : dp[i][col2] - dp[i][col1 - 1];
        }
        return sum;
    }
}
