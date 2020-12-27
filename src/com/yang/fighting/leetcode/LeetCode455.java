package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/25 09:57
 * @description https://leetcode-cn.com/problems/assign-cookies/
 */

public class LeetCode455 {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, res = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return res;
    }
}
