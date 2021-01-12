package com.yang.fighting.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/11 11:11
 * @description https://leetcode-cn.com/problems/smallest-string-with-swaps/  1202. 交换字符串中的元素
 */

public class LeetCode1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }
        Map<Integer, Set<Integer>> groupMap = new HashMap<>();
        Iterator<List<Integer>> iterator = pairs.listIterator();
        int[] indexArray = new int[s.length()];
        int uuid = 0;
        while (iterator.hasNext()) {
            List<Integer> list = iterator.next();
            // 如果都是0, 则说明之前没有出现过
            if (indexArray[list.get(0)] == 0 && indexArray[list.get(1)] == 0) {
                Set<Integer> newGroup = new HashSet<>(list);
                uuid++;
                groupMap.put(uuid, newGroup);
                indexArray[list.get(0)] = uuid;
                indexArray[list.get(1)] = uuid;
                continue;
            }
            // 如果一个不为0, 一个为0, 则加入之前的group
            if (indexArray[list.get(0)] != 0 && indexArray[list.get(1)] == 0) {
                indexArray[list.get(1)] = indexArray[list.get(0)];
                groupMap.get(indexArray[list.get(0)]).add(list.get(1));
                continue;
            }
            if (indexArray[list.get(0)] == 0 && indexArray[list.get(1)] != 0) {
                indexArray[list.get(0)] = indexArray[list.get(1)];
                groupMap.get(indexArray[list.get(1)]).add(list.get(0));
                continue;
            }
            // 如果两个都不为0，则进行分组合并
            if (indexArray[list.get(0)] != 0 && indexArray[list.get(1)] != 0) {
                Set<Integer> group = groupMap.get(indexArray[list.get(0)]);
                for (Integer integer : group) {
                    indexArray[integer] = indexArray[list.get(1)];
                }
                groupMap.get(indexArray[list.get(1)]).addAll(group);
            }
        }
        Map<Integer, List<Character>> resMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = indexArray[i];
            if (index == 0) {
                continue;
            }
            List<Character> list;
            if (resMap.containsKey(index)) {
                list = resMap.get(index);
                list.add(c);
            } else {
                List<Character> characterList = new LinkedList<>();
                characterList.add(c);
                resMap.put(index, characterList);
            }
        }
        for (Map.Entry<Integer, List<Character>> entry : resMap.entrySet()) {
            Collections.sort(entry.getValue());
        }
        char[] chars = new char[s.length()];
        for (int i = 0; i < chars.length; i++) {
            if (indexArray[i] == 0) {
                chars[i] = s.charAt(i);
            } else {
                List<Character> list = resMap.get(indexArray[i]);
                chars[i] = list.get(0);
                list.remove(0);
            }
        }
        return new String(chars);
    }
}
