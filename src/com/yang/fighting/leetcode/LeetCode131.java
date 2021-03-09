package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/8 12:50
 * @description https://leetcode-cn.com/problems/palindrome-partitioning/ 131. 分割回文串
 */

public class LeetCode131 {

    private List<List<String>> res;
    private List<String> temp;

    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (boolean[] array : dp) {
            Arrays.fill(array, true);
        }
        // dp processing
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }
        // Depth-First-Search
        res = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(s, 0, dp);
        return res;
    }

    private void dfs(String s, int index, boolean[][] dp) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                temp.add(s.substring(index, i + 1));
                dfs(s, i + 1, dp);
                // 一次深度搜索完清楚该层的元素  -  temp
                temp.remove(temp.size() - 1);
            }
        }
    }
}
