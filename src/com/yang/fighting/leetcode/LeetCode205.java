package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/27 23:10
 * @description
 */

public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        LinkedHashMap<Character, List<Integer>> sMap = new LinkedHashMap<>();
        LinkedHashMap<Character, List<Integer>> tMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            enrichMap(sMap, s.charAt(i), i);
            enrichMap(tMap, t.charAt(i), i);
        }
        Map<Character, Character> matchMap = new HashMap<>(tMap.size());
        Iterator<Map.Entry<Character, List<Integer>>> sIterator = sMap.entrySet().iterator();
        Iterator<Map.Entry<Character, List<Integer>>> tIterator = tMap.entrySet().iterator();
        while (sIterator.hasNext() || tIterator.hasNext()) {
            if (!sIterator.hasNext() || !tIterator.hasNext()) {
                return false;
            }
            Map.Entry<Character, List<Integer>> sEntry = sIterator.next();
            Map.Entry<Character, List<Integer>> tEntry = tIterator.next();
            if (matchMap.containsKey(tEntry.getKey())) {
                return false;
            }
            matchMap.put(tEntry.getKey(), sEntry.getKey());
            if (!compareList(sEntry.getValue(), tEntry.getValue())) {
                return false;
            }
        }
        return true;
    }

    private void enrichMap(LinkedHashMap<Character, List<Integer>> map, Character character, Integer index) {
        if (map.containsKey(character)) {
            map.get(character).add(index);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(index);
            map.put(character, list);
        }
    }

    private boolean compareList(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
