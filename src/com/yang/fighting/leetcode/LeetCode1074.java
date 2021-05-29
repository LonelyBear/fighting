package com.yang.fighting.leetcode;

import java.util.HashMap;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/29 23:21
 * @description https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/ 1074. 元素和为目标值的子矩阵数量
 */

public class LeetCode1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        int h = matrix.length, w = matrix[0].length;
        for (int i = 0; i < h; i++) {
            int[] array = new int[w];
            for (int j = i; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    array[k] += matrix[j][k];
                }
                res += apply(array, target);
            }
        }
        return res;
    }

    private int apply(int[] nums, int k) {
        int res = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // pre[i] - pre [j - 1] = k 则 nums[j] + ... + nums[i] == k
        // 先直当前 pre = 0
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            map.merge(pre, 1, Integer::sum);
        }
        return res;
    }
}
