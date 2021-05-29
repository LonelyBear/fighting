package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/28 09:42
 * @description https://leetcode-cn.com/problems/total-hamming-distance/ 477. 汉明距离总和
 */

public class LeetCode477 {
    public int totalHammingDistance(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                res += Integer.bitCount(nums[i] ^ nums[j]);
//            }
//        }
        for (int i = 0; i < 31; i++) {
            int one = 0;
            for (int num : nums) {
                one += (num >> i) & 1;
            }
            res += one * (nums.length - one);
        }
        return res;
    }
}
