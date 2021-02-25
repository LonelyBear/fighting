package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/25 10:29
 * @description https://leetcode-cn.com/problems/transpose-matrix/ 867. 转置矩阵
 */

public class LeetCode867 {

    public int[][] transpose(int[][] matrix) {
        int column = matrix.length;
        int row = matrix[0].length;
        int[][] res = new int[row][column];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
