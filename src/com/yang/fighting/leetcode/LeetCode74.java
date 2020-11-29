package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/29 18:24
 * @description https://leetcode-cn.com/problems/search-a-2d-matrix/
 */

public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 二分查找
        // 确定纵向区间
        int rowReft = 0, rowRight = matrix.length, rowMid = 0;
        while (rowReft + 1 < rowRight) {
            rowMid = (rowRight + rowReft) / 2;
            if (matrix[rowMid][0] == target) {
                return true;
            } else if (matrix[rowMid][0] < target) {
                rowReft = rowMid;
            } else {
                rowRight = rowMid;
            }
        }
        // 确定纵向区间
        int columnReft = 0, columnRight = matrix[0].length - 1, columnMid = 0;
        while (columnReft + 1 < columnRight) {
            columnMid = (columnReft + columnRight) / 2;
            if (matrix[rowReft][columnMid] == target) {
                return true;
            } else if (matrix[rowReft][columnMid] < target) {
                columnReft = columnMid;
            } else {
                columnRight = columnMid;
            }
        }
        return matrix[rowReft][columnReft] == target || matrix[rowReft][columnRight] == target;
    }
}
