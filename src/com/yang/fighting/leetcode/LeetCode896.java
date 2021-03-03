package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/28 13:58
 * @description https://leetcode-cn.com/problems/monotonic-array/ 896. 单调数列
 */

public class LeetCode896 {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1) {
            return true;
        }
        Boolean up = null;
        for (int i = 1; i < A.length; i++) {
            if (up == null) {
                up = A[i] == A[i - 1] ? null : (A[i] > A[i - 1]);
            } else {
                if (up) {
                    if (A[i] < A[i - 1]) {
                        return false;
                    }
                } else {
                    if (A[i] > A[i - 1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
