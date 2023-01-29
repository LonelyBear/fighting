package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @date 2023/1/20 17:33
 * @description https://leetcode.cn/problems/counting-words-with-a-given-prefix/ 2185. 统计包含给定前缀的字符串
 */
public class LeetCode2185 {
    public int prefixCount(String[] words, String pref) {
        if (words.length == 0 || pref.length() == 0) {
            return 0;
        }
        int prefSize = pref.length();
        return (int) Arrays.stream(words)
                .filter(word -> pref.equals(word.substring(0, Math.min(prefSize, word.length()))))
                .count();
    }
}
