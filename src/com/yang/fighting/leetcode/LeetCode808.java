package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/23 22:49
 * @description https://leetcode.cn/problems/soup-servings/ 808. 分汤
 */
public class LeetCode808 {

    private double[][] dp;

    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        //  当 n >= 179 * 25 时 概率为 0.999990211307 和 1.0 的差距小于1e-5
        if (n >= 179) {
            return 1;
        }
        dp = new double[n + 1][n + 1];
        return dpDfs(n, n);
    }

    private double dpDfs(int x, int y) {
        if (x <= 0 && y <= 0) {
            return 0.5;
        }
        if (x <= 0) {
            return 1;
        }
        if (y <= 0) {
            return 0;
        }
        if (dp[x][y] != 0) {
            dp[x][y] = 0.25 * (dpDfs(x - 4, y) + dpDfs(x - 3, y - 1) + dpDfs(x - 2, y - 2) + dpDfs(x - 1, y - 3));
        }
        return dp[x][y];
    }


    private static final List<int[]> plans = Arrays.asList(
            new int[]{100, 0},
            new int[]{75, 25},
            new int[]{50, 50},
            new int[]{25, 75}
    );
    private static final double NUM = 0.25d;

    public double soupServingsByDfs(int n) {
        List<Double> list = new ArrayList<>();
        double[] result = new double[]{0d};
        int[] pools = new int[]{n, n};
        dfs(result, list, pools);
        return result[0];
    }

    private void dfs(double[] result, List<Double> list, int[] pools) {
        for (int[] plan : plans) {
            list.add(NUM);
            if (pools[0] - plan[0] <= 0) {
                if (pools[1] - plan[1] > 0) {
                    result[0] += getValue(list);
                    list.remove(list.size() - 1);
                } else {
                    result[0] += getValue(list) * 0.5;
                    list.remove(list.size() - 1);
                }
            } else {
                if (pools[1] - plan[1] > 0) {
                    pools[0] -= plan[0];
                    pools[1] -= plan[1];
                    dfs(result, list, pools);
                    pools[0] += plan[0];
                    pools[1] += plan[1];
                    list.remove(list.size() - 1);
                } else {
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private double getValue(List<Double> list) {
        double result = 1d;
        for (double ele : list) {
            result *= ele;
        }
        return result;
    }


}
