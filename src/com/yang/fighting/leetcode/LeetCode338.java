package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/3 16:12
 * @description https://leetcode-cn.com/problems/counting-bits/ 338. 比特位计数
 */

public class LeetCode338 {
    public int[] countBits(int num) {
        int[] array = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                // 如果是偶数, 则该数和被它除2的数1的个数相同
                array[i] = array[i / 2];
            } else {
                // 如果是奇数, 则该数比它小1的数多1
                array[i] = array[i - 1] + 1;
            }
        }
        return array;
    }
}
