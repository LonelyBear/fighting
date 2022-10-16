package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/16 15:14
 * @description https://leetcode.cn/problems/possible-bipartition/ 886. 可能的二分法
 */
public class LeetCode886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(graph, color, i, 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 深度优先遍历
     *
     * @param graph             不喜欢的人
     * @param color             染色数组
     * @param index             当前的index
     * @param setColor          设置的颜色(0 未分组, 1-a 2-b)
     * @return
     */
    private boolean dfs(List<Integer>[] graph,
                     int[] color,
                     int index,
                     int setColor) {
        color[index] = setColor;
        for (int next : graph[index]) {
            if (color[next] == 0 && !dfs(graph, color, next, 3 ^ setColor)) {
                return false;
            }
            if (color[next] != 0 && color[next] == color[index]) {
                return false;
            }
        }
        return true;
    }
}
