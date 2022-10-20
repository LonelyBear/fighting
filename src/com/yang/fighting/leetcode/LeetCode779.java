package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/20 21:12
 * @description https://leetcode.cn/problems/k-th-symbol-in-grammar/ 779. 第K个语法符号
 */
public class LeetCode779 {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int a = ((k % 2) == 0) ?  k / 2 : k / 2 + 1;
        int b = k % 2;
        int kthGrammarUp = kthGrammar(n - 1, a);
        if (kthGrammarUp == 0) {
            if (b == 0) {
                return 1;
            }
            return 0;
        } else {
            if (b == 0) {
                return 0;
            }
            return 1;
        }
    }
}
