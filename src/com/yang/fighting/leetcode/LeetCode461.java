package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/27 10:41
 * @description https://leetcode-cn.com/problems/hamming-distance/ 461.汉明距离
 */

public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int c = x ^ y;
        int count = 0;
        while (c > 0) {
            if ((c & 1) == 1) {
                count++;
            }
            c = c >> 1;
        }
        return count;
    }
}
