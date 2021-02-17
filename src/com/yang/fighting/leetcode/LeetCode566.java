package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/17 08:10
 * @description https://leetcode-cn.com/problems/reshape-the-matrix/ 566. 重塑矩阵
 */

public class LeetCode566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int column = nums.length;
        int row = nums[0].length;
        if (column * row != r * c) return nums;
        int[] temp = new int[column * row];
        int[][] res = new int[r][c];
        int count = 0;
        for (int[] num : nums) {
            for (int j = 0; j < row; j++) {
                temp[count++] = num[j];
            }
        }
        count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = temp[count++];
            }
        }
        return res;
    }
}
