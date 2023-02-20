package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/19 19:30
 * @description https://leetcode.cn/problems/find-positive-integer-solution-for-a-given-equation/ 1237. 找出给定方程的正整数解
 */
public class LeetCode1237 {
    // 阅读理解的题没啥价值
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int x = 1; x < 1000; x++) {
            for (int y = 1; y < 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    result.add(Arrays.asList(x, y));
                }
            }
        }
        return result;
    }


    private interface CustomFunction {
        int f(int x, int y);
    }
}
