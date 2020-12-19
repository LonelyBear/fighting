package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/16 17:36
 * @description https://leetcode-cn.com/problems/word-pattern/
 */

public class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {
        if (s.length() == 0) {
            return false;
        }
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            List<Integer> list;
            if (map.containsKey(c)) {
                list = map.get(c);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(c, list);
        }
        Collection<List<Integer>> collections = map.values();
        Set<String> wordSet = new HashSet<>();
        for (List<Integer> list : collections) {
            String s1 = strings[list.get(0)];
            // 判断是否相同
            if (wordSet.contains(s1)) {
                return false;
            }
            wordSet.add(s1);
            for (int i = 1; i < list.size(); i++) {
                if (!s1.equals(strings[list.get(i)])) {
                    return false;
                }
            }
        }
        return true;
    }
}
