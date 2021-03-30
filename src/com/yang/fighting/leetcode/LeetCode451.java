package com.yang.fighting.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/30 10:26
 * @description https://leetcode-cn.com/problems/sort-characters-by-frequency/ 451. 根据字符出现频率排序
 */

public class LeetCode451 {
    public String frequencySort(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        char[] array = s.toCharArray();
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : array) {
            countMap.merge(c, 1, Integer::sum);
        }
        List<Map.Entry<Character, Integer>> list = countMap.entrySet().stream().sorted(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        }).collect(Collectors.toList());
        int index = 0;
        for (Map.Entry<Character, Integer> e: list) {
            int count = e.getValue();
            for (int i = 0; i < count; i++) {
                array[index++] = e.getKey();
            }
        }
        return String.valueOf(array);
    }
}
