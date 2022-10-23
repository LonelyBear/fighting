package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/23 11:13
 * @description https://leetcode.cn/problems/merge-strings-alternately/ 1768. 交替合并字符串
 */
public class LeetCode1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
            if (i < word1.length()) {
                stringBuilder.append(array1[i]);
            }
            if (i < word2.length()) {
                stringBuilder.append(array2[i]);
            }
        }
        return stringBuilder.toString();
    }
}
