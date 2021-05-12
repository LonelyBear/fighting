package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/12 10:57
 * @description https://leetcode-cn.com/problems/xor-queries-of-a-subarray/ 1310. 子数组异或查询
 */

public class LeetCode1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] tmp = new int[arr.length + 1];
        int[] res = new int[queries.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i + 1] = tmp[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = tmp[queries[i][0]] ^ tmp[queries[i][1] + 1];
        }
        return res;
    }
}
