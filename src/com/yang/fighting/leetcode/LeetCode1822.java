package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/27 21:40
 * @description https://leetcode.cn/problems/sign-of-the-product-of-an-array/ 1822. 数组元素积的符号
 */
public class LeetCode1822 {
    public int arraySign(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                cnt++;
            }
        }
        if (cnt % 2 == 0) {
            return 1;
        }
        return -1;
    }
}
