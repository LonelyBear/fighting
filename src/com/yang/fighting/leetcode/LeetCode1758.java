package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/29 22:34
 * @description https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/ 1758. 生成交替二进制字符串的最少操作数
 */
public class LeetCode1758 {
    public int minOperations(String s) {
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            boolean zero = (i == 1);
            for (int j = 0; j < s.length(); j++) {
                if (zero) {
                    if (s.charAt(j) != '0') {
                        result[i] ++;
                    }
                } else {
                    if (s.charAt(j) != '1') {
                        result[i] ++;
                    }
                }
                zero = !zero;
            }
        }
        return Math.min(result[0], result[1]);
    }

}
