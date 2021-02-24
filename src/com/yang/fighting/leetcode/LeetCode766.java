package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/22 10:04
 * @description https://leetcode-cn.com/problems/toeplitz-matrix/ 766. 托普利茨矩阵
 */

public class LeetCode766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int column = matrix.length;
        int row = matrix[0].length;
        boolean[][] checkMatrix = new boolean[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if (!checkMatrix[i][j]) {
                    int k = i + 1;
                    int l = j + 1;
                    while (k < column && l < row) {
                        if (matrix[k][l] != matrix[i][j]) {
                            return false;
                        }
                        checkMatrix[k][l] = true;
                        k += 1;
                        l += 1;
                    }
                }
            }
        }
        return true;
    }
}
