package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/9 22:13
 * @description https://leetcode.cn/problems/largest-plus-sign/ 764. 最大加号标志
 */
public class LeetCode764 {


    public int orderOfLargestPlusSign(int n, int[][] mines) {

        Set<Integer> zeroSet = new HashSet<>();
        for (int[] mine : mines) {
            zeroSet.add(getIndex(mine[0], mine[1], n));
        }
        int[][] dp = new int[n][n];
        // 初始化为最大数
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        // 计算上下左右四个方向的1的前缀和
        // dp数组是四个方向的最小数
        int result = 0, cnt;
        for (int i = 0; i < n; i++) {
            // 从左到右
            cnt = 0;
            for (int j = 0; j < n; j++) {
                if (zeroSet.contains(getIndex(i, j, n))) {
                    cnt = 0;
                } else {
                    cnt++;
                }
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
            cnt = 0;
            // 从右到左
            for (int j = n - 1; j >= 0; j--) {
                if (zeroSet.contains(getIndex(i, j, n))) {
                    cnt = 0;
                } else {
                    cnt++;
                }
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
        }
        for (int j = 0; j < n; j++) {
            // 从上到下
            cnt = 0;
            for (int i = 0; i < n; i++) {
                if (zeroSet.contains(getIndex(i, j, n))) {
                    cnt = 0;
                } else {
                    cnt++;
                }
                dp[i][j] = Math.min(dp[i][j], cnt);
            }
            // 从下到上
            cnt = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (zeroSet.contains(getIndex(i, j, n))) {
                    cnt = 0;
                } else {
                    cnt++;
                }
                dp[i][j] = Math.min(dp[i][j], cnt);
                result = Math.max(dp[i][j], result);
            }
            
        }
        return result;
    }


    private int getIndex(int x, int y, int n) {
        return x * n + y;
    }


}
