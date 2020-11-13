package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/12 08:48
 * @description https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */

public class LeetCode922 {

    public int[] sortArrayByParityII(int[] A) {
        if (A.length == 0) {
            return new int[0];
        }
        int[] odd = new int[A.length / 2];
        int odd_i = 0;
        int[] even = new int[A.length / 2];
        int even_i = 0;
        int[] res = new int[A.length];
        for (int j : A) {
            if (j % 2 == 0) {
                even[even_i] = j;
                even_i++;
            } else {
                odd[odd_i] = j;
                odd_i++;
            }
        }
        for (int i = 0; i < A.length / 2; i++) {
            res[2 * i] = even[i];
            res[2 * i + 1] = odd[i];
        }
        return res;
    }
}
