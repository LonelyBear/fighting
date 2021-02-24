package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/24 15:22
 * @description https://leetcode-cn.com/problems/flipping-an-image/ 832. 翻转图像
 */

public class LeetCode832 {

    public int[][] flipAndInvertImage(int[][] A) {
        int column = A.length;
        int row = A[0].length;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j <= row / 2; j++) {
                System.out.println("x = " + i + " y = " + j);
                if (j == row / 2) {
                    if (row % 2 != 0) {
                        A[i][j] = getRes(A[i][j]);
                    }
                    continue;
                }
                int tmp = A[i][getResIndex(row, j)];
                A[i][j] = getRes(tmp);
                A[i][getResIndex(row, j)] = getRes(A[i][j]);
            }
        }
        return A;
    }

    private int getResIndex(int row, int index) {
        return row - 1 - index;
    }

    private int getRes(int input) {
        if (input == 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
