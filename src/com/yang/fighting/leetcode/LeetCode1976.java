package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2024/3/5 22:28
 * @description
 */
public class LeetCode1976 {

    public int countPaths(int n, int[][] roads) {
        long[][] g = new long[n][n];
        for (long[] row : g) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        for (int[] r : roads) {
            int x = r[0];
            int y = r[1];
            int cost = r[2];
            g[x][y] = cost;
            g[y][x] = cost;
        }
        //visited[i] 表示被算了最短值的i节点有没有被用于作为中间节点更新其他节点的最小值
        boolean[] visited = new boolean[n];
        // dis[i]表示0-i节点的最短值 初始都是无穷大  /2 是为了防止溢出
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE / 2);
        dis[0] = 0;
        // res[i]表示0-i节点最短值的数目
        int[] res = new int[n];
        res[0] = 1;
        while (true) {
            // 为了记录目前最短的节点
            int x = -1;
            for (int i = 0; i < n; i++) {
                // 去找目前已知最小值的节点 以此为中间节点来算剩余节点的最小值
                // 上一轮被计算了最小值的节点 此时visited状态都没有被改变 所以if第一个判断要加！符号
                if (!visited[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            // 到n-1节点的最短值已经被算过了 之后不会有更短的路径了 直接返回
            if (x == n - 1) {
                return res[n - 1];
            }
            visited[x] = true;
            for (int y = 0; y < n; y++) {
                long newDis = dis[x] + g[x][y];
                if (newDis < dis[y]) {
                    dis[y] = newDis;
                    // 到x有多少条最短路 到y就有多少条
                    res[y] = res[x];
                } else if (newDis == dis[y]) {
                    res[y] = (res[y] + res[x]) % 1000000007;
                }
            }
        }
    }
}
