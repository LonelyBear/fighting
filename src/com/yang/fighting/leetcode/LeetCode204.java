package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/3 10:28
 * @description https://leetcode-cn.com/problems/count-primes/
 */

public class LeetCode204 {

    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int count = 0;
        boolean[] noPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!noPrime[i]) {
                count++;
            }
            for (int j = 1; j * i < n; j++) {
                noPrime[j * i] = true;
            }
        }
        return count;
    }
}
