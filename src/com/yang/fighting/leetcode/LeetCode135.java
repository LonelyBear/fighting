package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/24 14:17
 * @description https://leetcode-cn.com/problems/candy/
 */

public class LeetCode135 {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        /*
         * 分两次遍历:
         * 从左到右: 遇到比上一个大的加1, 否则置为1
         * 从右到左: 遇到比上一个大的加1, 否则置为1
         */
        int[] left = new int[ratings.length];
        for (int i = 0; i < left.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0;
        int res = 0;
        for (int i = left.length - 1; i >= 0; i--) {
            if (i < left.length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            left[i] = Math.max(left[i], right);
            res = left[i] + res;
        }
        return res;
    }
}
