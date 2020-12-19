package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/15 19:28
 * @description https://leetcode-cn.com/problems/monotone-increasing-digits/
 */

public class LeetCode738 {
    /**
     * 从后往前遍历, 如果找到比前一位大的数, 则将前一位数字减1, 并把当前到最后所有的位数赋值为9,
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        char[] array = String.valueOf(N).toCharArray();
        int tmp = array.length;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                array[i-1]--;
                for (int j = i; j < tmp; j++) {
                    array[j] = '9';
                }
                tmp = i;
            }
        }
        return Integer.parseInt(String.valueOf(array));
    }
}
