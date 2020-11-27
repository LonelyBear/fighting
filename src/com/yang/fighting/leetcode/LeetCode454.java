package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/27 20:09
 * @description https://leetcode-cn.com/problems/4sum-ii/
 */

public class LeetCode454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0) {
            return 0;
        }
//        int length = A.length;
//        int res = 0;
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                for (int k = 0; k < length; k++) {
//                    for (int l = 0; l < length; l++) {
//                        if (A[i] + B[j] + C[k] + D[l] == 0) {
//                            res++;
//                        }
//                    }
//                }
//            }
//        }
//        return res;
        // 分组A + B = - (C + D)  求和
        Map<Integer, Integer> countForAB = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                countForAB.merge(i + j, 1, Integer::sum);
            }
        }
        int res = 0;
        for (int u : C) {
            for (int v : D) {
                if (countForAB.containsKey(-u - v)) {
                    res += countForAB.get(-u - v);
                }
            }
        }
        return res;
    }
}
