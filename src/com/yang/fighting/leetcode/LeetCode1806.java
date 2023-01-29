package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author yangtao
 * @date 2023/1/20 19:01
 * @description https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/ 1806. 还原排列的最少操作步数
 */
public class LeetCode1806 {
    public int reinitializePermutation(int n) {
        int[] perm = IntStream.iterate(0, num -> num + 1).limit(n).toArray();
        int[] arr = new int[n];
        int count = 0;
        do {
            count++;
        } while (!process(perm, arr));
        return count;
    }

    private boolean process(int[] perm, int[] arr) {
        for (int i = 0; i < perm.length; i++) {
            if (i % 2 == 0) {
                arr[i] = perm[i / 2];
            } else {
                arr[i] = perm[perm.length / 2 + (i - 1) / 2];
            }
        }
        boolean res = true;
        for (int i = 0; i < perm.length; i++) {
            perm[i] = arr[i];
            if (perm[i] != i) {
                res = false;
            }
        }
        return res;
    }

}
