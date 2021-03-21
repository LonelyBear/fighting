package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/21 10:08
 * @description https://leetcode-cn.com/problems/set-matrix-zeroes/ 73. 矩阵置零
 */

public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] column = new boolean[m];
        boolean[] row = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    column[i] = true;
                    row[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (column[i] || row[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
