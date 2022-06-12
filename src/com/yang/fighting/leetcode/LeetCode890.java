package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/6/12 10:23
 * @description https://leetcode.cn/problems/find-and-replace-pattern/ 890. 查找和替换模式
 */
public class LeetCode890 {
    /**
     * solve
     *
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char[] patternArray = pattern.toCharArray();
        return new ArrayList<>(Arrays.asList(words)).stream()
                .filter(word -> checkWord(word.toCharArray(), patternArray))
                .collect(Collectors.toList());
    }

    /**
     * 检查单词
     *
     * @param wordArray
     * @param patternArray
     * @return
     */
    private boolean checkWord(char[] wordArray, char[] patternArray) {
        Map<Character, Character> frontMap = new HashMap<>();
        Map<Character, Character> backMap = new HashMap<>();
        for (int i = 0; i < wordArray.length; i++) {
            if (!frontMap.containsKey(wordArray[i]) && !backMap.containsKey(patternArray[i])) {
                frontMap.put(wordArray[i], patternArray[i]);
                backMap.put(patternArray[i], wordArray[i]);
                continue;
            }
            if (frontMap.containsKey(wordArray[i])) {
                if (!backMap.containsKey(patternArray[i])) {
                    return false;
                }
                if (wordArray[i] != backMap.get(patternArray[i])) {
                    return false;
                }
            }
            if (backMap.containsKey(patternArray[i])) {
                if (!frontMap.containsKey(wordArray[i])) {
                    return false;
                }
                if (frontMap.get(wordArray[i]) != patternArray[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
