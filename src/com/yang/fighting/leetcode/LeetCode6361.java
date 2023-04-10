package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/9 12:16
 * @description https://leetcode.cn/problems/prime-in-diagonal/ 6361. 对角线上的质数
 */
public class LeetCode6361 {
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if (i == j || i + j == len -1) {
                    if (check(nums[i][j])) {
                        ans = Math.max(ans, nums[i][j]);
                    }
                }
            }
        }
        return ans;
    }

    private boolean check(int num) {
        if (num <= 1) {
            return false;
        }
        int k = (int) Math.sqrt(num);
        for(int i = 2; i <= k; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
