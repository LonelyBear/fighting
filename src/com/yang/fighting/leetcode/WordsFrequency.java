package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/1 21:10
 * @description https://leetcode-cn.com/problems/words-frequency-lcci/ 面试题 16.02. 单词频率
 */

public class WordsFrequency {

    private final Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for (String s : book) {
            map.merge(s, 1, Integer::sum);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}
