package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @date 2023/1/23 18:22
 * @description https://leetcode.cn/problems/sentence-similarity-iii/ 1813. 句子相似性 III
 */
public class LeetCode1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] wordArray1 = sentence1.split(" ");
        String[] wordArray2 = sentence2.split(" ");
        int left = 0, right = 0;
        // left - 左边相同的单词数量
        // right - 右边相同的单词数量 right 要小于 Math.min(wordArray1.length, wordArray2.length) - left
        while (left < wordArray1.length
                && left < wordArray2.length
                && wordArray1[left].equals(wordArray2[left])) {
            left++;
        }
        while (right < wordArray1.length - left
                && right < wordArray2.length - left
                && wordArray1[wordArray1.length - 1 - right].equals(wordArray2[wordArray2.length - 1 - right])) {
            right++;
        }
        return right + left == Math.min(wordArray1.length, wordArray2.length);
    }
}
