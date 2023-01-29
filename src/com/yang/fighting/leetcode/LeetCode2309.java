package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @date 2023/1/27 09:46
 * @description https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/ 2309. 兼具大小写的最好英文字母
 */
public class LeetCode2309 {
    public String greatestLetter(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] charArray = s.toCharArray();
        // 01-只含小写 10-只含大写 11-都包含
        Map<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            if (c >= 'a' && c <= 'z') {
                char bigChar = (char) (c - 32);
                if (map.containsKey(bigChar)) {
                    map.compute(bigChar, (key, oldVal) -> oldVal | 0b01);
                } else {
                    map.put(bigChar, 0b01);
                }
            } else {
                if (map.containsKey(c)) {
                    map.compute(c, (key, oldVal) -> oldVal | 0b10);
                } else {
                    map.put(c, 0b10);
                }
            }
        }
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 3)
                .sorted((o1, o2) -> Character.compare(o2.getKey(), o1.getKey())).map(Map.Entry::getKey)
                .map(String::valueOf)
                .findFirst()
                .orElse("");
    }
}
