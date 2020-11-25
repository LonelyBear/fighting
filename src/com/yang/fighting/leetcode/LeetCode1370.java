package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/25 11:11
 * @description https://leetcode-cn.com/problems/increasing-decreasing-string/
 */

public class LeetCode1370 {
    public String sortString(String s) {
        // 可以使用桶排序的方式来 建立数组排序
        if (s.length() <= 1) {
            return s;
        }
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (treeMap.containsKey(s.charAt(i))) {
                treeMap.put(s.charAt(i), treeMap.get(s.charAt(i)) + 1);
            } else {
                treeMap.put(s.charAt(i), 1);
            }
        }
        List<Character> list = new ArrayList<>();
        boolean asc = true;
        while (!treeMap.isEmpty()) {
            List<Character> tmp = new ArrayList<>();
            Iterator<Map.Entry<Character, Integer>> iterator = treeMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> entry = iterator.next();
                tmp.add(entry.getKey());
                if (entry.getValue() == 1) {
                    iterator.remove();
                } else {
                    entry.setValue(entry.getValue() - 1);
                }
            }
            if (!asc) {
                Collections.reverse(tmp);
                asc = true;
            } else {
                asc = false;
            }
            list.addAll(tmp);
        }
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
