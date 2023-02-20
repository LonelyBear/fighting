package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/12 14:46
 * @description https://leetcode.cn/problems/alphabet-board-path/ 1138. 字母板上的路径
 */
public class LeetCode1138 {
    public String alphabetBoardPath(String target) {
        char[] array = target.toCharArray();
        char cur = 'a';
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : array) {
            String path = path(cur, c);
            stringBuilder.append(path);
            cur = c;
        }
        return stringBuilder.toString();
    }

    private String path(char cur, char target) {
        StringBuilder pathBuilder = new StringBuilder();
        if (cur == target) {
            pathBuilder.append('!');
        } else {
            if (cur == 'z') {
                pathBuilder.append('U');
                String walkPath = walkPath('u', target);
                if (walkPath != null) {
                    pathBuilder.append(walkPath);
                }
            } else if (target == 'z') {
                String walkPath = walkPath(cur, 'u');
                if (walkPath != null) {
                    pathBuilder.append(walkPath);
                }
                pathBuilder.append('D');
            } else {
                pathBuilder.append(walkPath(cur, target));
            }
            pathBuilder.append('!');
        }
        return pathBuilder.toString();
    }

    private String walkPath(char cur, char target) {
        if (cur == target) {
            return null;
        }
        StringBuilder walkBuilder = new StringBuilder();
        int[] curIndex = index(cur);
        int[] targetIndex = index(target);
        int row = targetIndex[0] - curIndex[0];
        int col = targetIndex[1] - curIndex[1];
        for (int i = 0; i < Math.abs(row); i++) {
            if (row > 0) {
                walkBuilder.append('D');
            } else {
                walkBuilder.append('U');
            }
        }
        for (int i = 0; i < Math.abs(col); i++) {
            if (col > 0) {
                walkBuilder.append('R');
            } else {
                walkBuilder.append('L');
            }
        }
        return walkBuilder.toString();
    }


    private int[] index(char c) {
        int dis = c - 'a';
        return new int[] {dis / 5, dis - ((dis / 5) * 5)};
    }
}
