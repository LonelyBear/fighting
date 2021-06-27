package com.yang.fighting.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/27 08:50
 * @description https://leetcode-cn.com/problems/snakes-and-ladders/ 909. 蛇梯棋
 */

public class LeetCode909 {

    public int snakesAndLadders(int[][] board) {
        int M = board.length;
        boolean[] visited = new boolean[M * M + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {1, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;
                if (next > M * M) {
                    break;
                }
                int[] index = id2rc(next, M);
                if (board[index[0]][index[1]] != -1) {
                    next = board[index[0]][index[1]];
                }
                if (next == M * M) {
                    return cur[1] + 1;
                }
                // 标记已经遍历过该点
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[] {next, cur[1] + 1});
                }
            }
        }
        return -1;
    }

    /**
     * 坐标转换
     *
     * @param id
     * @param n
     * @return
     */
    public int[] id2rc(int id, int n) {
        int r = (id - 1) / n, c = (id - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }

}
