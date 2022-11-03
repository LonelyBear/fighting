package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/1 22:18
 * @description https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/ 1662. 检查两个字符串数组是否相等
 */
public class LeetCode1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        enrichBuilder(builder1, word1);
        enrichBuilder(builder2, word2);
        return builder1.toString().equals(builder2.toString());
    }

    private void enrichBuilder(StringBuilder builder, String[] words) {
        for (String word : words) {
            builder.append(word);
        }
    }
}
