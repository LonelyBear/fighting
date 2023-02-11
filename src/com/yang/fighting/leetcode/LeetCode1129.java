package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/2 21:52
 * @description https://leetcode.cn/problems/shortest-path-with-alternating-colors/ 1129. 颜色交替的最短路径
 */
public class LeetCode1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] graph = new List[2][n];
        for (var ele : graph) {
            Arrays.setAll(ele, k -> new ArrayList<>());
        }
        for (var e : redEdges) {
            graph[0][e[0]].add(e[1]);
        }
        for (var e : blueEdges) {
            graph[1][e[0]].add(e[1]);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        boolean[][] vis = new boolean[n][2];
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int d = 0;
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; --k) {
                var p = q.poll();
                assert p != null;
                int i = p[0], c = p[1];
                if (ans[i] == -1) {
                    ans[i] = d;
                }
                vis[i][c] = true;
                c ^= 1;
                for (int j : graph[c][i]) {
                    if (!vis[j][c]) {
                        q.offer(new int[]{j, c});
                    }
                }
            }
            ++d;
        }
        return ans;

    }

}
