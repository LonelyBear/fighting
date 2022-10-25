package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/25 22:02
 * @description https://leetcode.cn/problems/shortest-bridge/ 934. 最短的桥
 */
public class LeetCode934 {

    private static final int init = 10010;
    private static final int[] collection = new int[init];
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int len;

    // 获取并查集index
    private int getIndex(int x, int y) {
        return x * len + y;
    }

    // 获取并查集 index 对应的集合代表元素
    private int findRoot(int index) {
        if (collection[index] == index) {
            return collection[index];
        }
        return findRoot(collection[index]);
    }

    // 合并集合
    private void union(int index1, int index2) {
        collection[findRoot(index1)] = collection[findRoot(index2)];
    }

    // 初始化并查集
    private void init(int[] collection) {
        for (int i = 0; i < len * len; i++) {
            collection[i] = i;
        }
    }

    // 判断是否属于范围外
    private boolean checkInvalid(int x, int y) {
        return x < 0 || x >= len || y < 0 || y >= len;
    }

    private int bfs(Deque<int[]> deque,
                     Map<Integer, Integer> stepMap,
                     Map<Integer, Integer> stepMapOther) {
        int size = deque.size();
        while (size-- > 0) {
            int[] ele = deque.pollFirst();
            assert ele != null;
            int x = ele[0], y = ele[1], index = getIndex(x, y), step = stepMap.get(index);
            for (int[] direction : directions) {
                int x1 = direction[0] + x, y1 = direction[1] + y, index1 = getIndex(x1, y1);
                if (checkInvalid(x1, y1)) {
                    continue;
                }
                if (stepMap.containsKey(index1)) {
                    continue;
                }
                if (stepMapOther.containsKey(index1)) {
                    return step + stepMapOther.get(index1);
                }
                deque.addLast(new int[]{x1, y1});
                stepMap.put(index1, step + 1);
            }
        }
        return -1;
    }


    public int shortestBridge(int[][] grid) {
        len = grid.length;
        // 通过并查集方式 找到连通域
        init(collection);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int[] direction : directions) {
                    int x = i + direction[0], y = j + direction[1];
                    if (checkInvalid(x, y) || grid[x][y] == 0) {
                        continue;
                    }
                    union(getIndex(i, j), getIndex(x, y));
                }
            }
        }
        int groupA = -1, groupB = -1;
        Deque<int[]> dequeA = new ArrayDeque<>(), dequeB = new ArrayDeque<>();
        Map<Integer, Integer> stepMapA = new HashMap<>(), stepMapB = new HashMap<>();
        // 将两个岛进行分片
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int index = getIndex(i, j), root = findRoot(index);
                if (groupA == -1) {
                    groupA = root;
                } else if (groupA != root && groupB == -1) {
                    groupB = root;
                }
                if (root == groupA) {
                    dequeA.addLast(new int[]{i, j});
                    stepMapA.put(index, 0);
                }
                if (root == groupB) {
                    dequeB.addLast(new int[]{i, j});
                    stepMapB.put(index, 0);
                }
            }
        }
        // 通过双向bfs 获取最小值
        while (!dequeA.isEmpty() && !dequeB.isEmpty()) {
            int ans = -1;
            if (dequeA.size() < dequeB.size()) {
                ans = bfs(dequeA, stepMapA, stepMapB);
            } else {
                ans = bfs(dequeB, stepMapB, stepMapA);
            }
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }


}
