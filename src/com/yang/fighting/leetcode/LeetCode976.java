package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/29 11:42
 * @description https://leetcode-cn.com/problems/largest-perimeter-triangle/
 */
public class LeetCode976 {
    public int largestPerimeter(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        // 先排序
        Arrays.sort(A);
        // 从后往前找到符合的
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i-1] + A[i-2] > A[i]) {
                return A[i-1] + A[i-2] + A[i];
            }
        }
        return 0;
    }
}
