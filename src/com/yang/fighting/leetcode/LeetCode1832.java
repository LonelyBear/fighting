package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/12/13 22:10
 * @description https://leetcode.cn/problems/check-if-the-sentence-is-pangram/ 1832. 判断句子是否为全字母句
 */
public class LeetCode1832 {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            set.add((char)('a' + i));
        }
        for (int i = 0; i < sentence.length(); i++) {
            if (set.isEmpty()) {
                return true;
            }
            set.remove(sentence.charAt(i));
        }
        return set.isEmpty();
    }
}
