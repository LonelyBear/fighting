package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/6/13 22:08
 * @description https://leetcode.cn/problems/height-checker/ 1051. 高度检查器
 */
public class LeetCode1051 {
    public int heightChecker(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int res = 0;
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }
}
