package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2024/4/4 21:24
 * @description
 */
public class LeetCode2192 {

    private List<Integer>[] ans;
    private List<Integer>[] graph;
    private int len;
    private boolean[] visited;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        init(edges, n);
        for (int i = 0; i < len; i++) {
            Arrays.fill(visited, false);
            dfs(i);
            visited[i] = false;
            for (int j = 0; j < len; j++) {
                if (visited[j]) {
                    ans[i].add(j);
                }
            }
        }
        return Arrays.asList(ans);
    }

    private void init(int[][] edges, int n) {
        len = n;
        graph = new ArrayList[len];
        Arrays.setAll(graph, k -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
        }
        ans = new ArrayList[len];
        Arrays.setAll(ans, k -> new ArrayList<>());
        visited = new boolean[len];
    }

    private void dfs(int i) {
        visited[i] = true;
        for (int next : graph[i]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

}
