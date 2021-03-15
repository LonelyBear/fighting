package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/15 11:17
 * @description https://leetcode-cn.com/problems/spiral-matrix/ 54. 螺旋矩阵
 */

public class LeetCode54 {

    private List<Integer> res;

    public List<Integer> spiralOrder(int[][] matrix) {
        int column = matrix.length;
        int row = matrix[0].length;
        res = new ArrayList<>();
        process(matrix, column, row, 0, 0);
        return res;
    }

    private void process(int[][] matrix, int column, int row, int X, int Y) {
        if (column < 1 || row < 1) {
            return;
        }
        if (column == 1 || row == 1) {
            // 如果剩1行就遍历该行返回最后结果
            if (column == 1) {
                for (int i = 0; i < row; i++) {
                    res.add(matrix[X][Y + i]);
                }
            } else {
                for (int i = 0; i < column; i++) {
                    res.add(matrix[X + i][Y]);
                }
            }
            return;
        }
        // 循环一次外圈元素
        for (int i = 0; i < row; i++) {
            res.add(matrix[X][Y + i]);
        }
        for (int i = 1; i < column; i++) {
            res.add(matrix[X + i][Y + row - 1]);
        }
        for (int i = 1; i < row; i++) {
            res.add(matrix[X + column - 1][Y + row - 1 - i]);
        }
        for (int i = 1; i < column - 1; i++) {
            res.add(matrix[X + column - 1 - i][Y]);
        }
        process(matrix, column - 2, row - 2, X + 1, Y + 1);
    }


}
