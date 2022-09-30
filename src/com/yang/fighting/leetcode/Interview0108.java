package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/9/30 20:52
 * @description https://leetcode.cn/problems/zero-matrix-lcci/ 面试题 01.08. 零矩阵
 */
public class Interview0108 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        Set<Integer> colSet = new HashSet<>();
        Set<Integer> rowSet = new HashSet<>();
        cycle0(colSet, rowSet, matrix);
        cycle1(colSet, rowSet, matrix);
    }

    private void cycle0(Set<Integer> colSet, Set<Integer> rowSet, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    colSet.add(i);
                    rowSet.add(j);
                }
            }
        }
    }

    private void cycle1(Set<Integer> colSet, Set<Integer> rowSet, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (colSet.contains(i) || rowSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
