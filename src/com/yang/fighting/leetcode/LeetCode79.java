package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/25 21:01
 * @description https://leetcode.cn/problems/word-search/?favorite=2cktkvj 79. 单词搜索
 */
public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        Map<Character, Set<int[]>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (map.containsKey(c)) {
                    map.get(c).add(new int[] {i, j});
                } else {
                    Set<int[]> set = new HashSet<>();
                    set.add(new int[] {i, j});
                    map.put(c, set);
                }
            }
        }
        char[] charArray = word.toCharArray();
        Result result = new Result();
        // 此处偷懒一开始用了 hashSet 就会在查询和remove的时候超时
        boolean[][] select = new boolean[board.length][board[0].length];
        process(result, charArray, map, select, null, 0);
        return result.isAns();
    }

    private void process(Result result,
                         char[] charArray,
                         Map<Character, Set<int[]>> map,
                         boolean[][] select,
                         int[] last,
                         int index) {
        Set<int[]> charSet = map.get(charArray[index]);
        if (charSet == null) {
            return;
        }
        if (index == charArray.length - 1) {
            for (int[] ele : charSet) {
                if (select[ele[0]][ele[1]] || !check(last, ele)) {
                    continue;
                }
                result.success();
            }
            return;
        }
        for (int[] ele : charSet) {
            if (select[ele[0]][ele[1]] || !check(last, ele)) {
                continue;
            }
            select[ele[0]][ele[1]] = true;
            process(result, charArray, map, select, ele, index + 1);
            if (result.isAns()) {
                return;
            }
            select[ele[0]][ele[1]] = false;
        }
    }

    private boolean check(int[] last, int[] cur) {
        if (last == null) {
            return true;
        }
        boolean res = false;
        if (last[0] == cur[0]) {
            if (Math.abs(last[1] - cur[1]) == 1) {
                res = true;
            }
        }
        if (last[1] == cur[1]) {
            if (Math.abs(last[0] - cur[0]) == 1) {
                res = true;
            }
        }
        return res;
    }


    private static class Result {
        private boolean ans;

        public boolean isAns() {
            return ans;
        }

        public Result() {
        }

        public void success() {
            this.ans = true;
        }
    }
}
