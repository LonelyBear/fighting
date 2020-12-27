package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/23 11:16
 * @description https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */

public class LeetCode387 {
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        LinkedHashMap<Character, List<Integer>> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(chars[i], list);
            } else {
                map.get(chars[i]).add(i);
            }
        }
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() < 2) {
                return entry.getValue().get(0);
            }
        }
        return -1;
    }
}
