package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/19 11:09
 * @description https://leetcode-cn.com/problems/rotate-image/
 * 旋转图像
 */

public class LeetCode48 {
    public void rotate(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }
        // n - 矩阵维度
        int n = matrix.length;
        // 需要旋转圈圈的次数
        int swapCount = n / 2;
        for (int i = 1; i <= swapCount; i++) {
            swap(matrix, i);
        }
        return;
    }

    /**
     * 圈圈元素交换
     *
     * @param matrix    矩阵数组
     * @param swapCount 当前旋转圈圈的次数
     */
    private void swap(int[][] matrix, int swapCount) {
        // 计算当前圈圈第一个元素的坐标
        int iniX = matrix.length / 2 - swapCount;
        int iniY = matrix.length / 2 - swapCount;
        // 计算每条边的长度
        int length = matrix.length % 2 == 0 ? 2 * swapCount : swapCount * 2 + 1;
        int[] tmp = Arrays.copyOfRange(matrix[iniX], iniY, iniY + length);
        for (int i = 0; i < length; i++) {
            matrix[iniX][iniY + length - 1 - i] = matrix[iniX + i][iniY];
        }
        for (int i = 0; i < length; i++) {
            matrix[iniX + i][iniY] = matrix[iniX + length - 1][iniY + i];
        }
        for (int i = 0; i < length; i++) {
            matrix[iniX + length - 1][iniY + i] = matrix[iniX + length - 1 - i][iniY + length - 1];
        }
        for (int i = 0; i < length; i++) {
            matrix[iniX + length - 1 - i][iniY + length - 1] = tmp[length - 1 - i];
        }

    }
}
