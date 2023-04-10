package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/9 13:24
 * @description https://leetcode.cn/problems/check-distances-between-same-letters/ 2399. 检查相同字母间的距离
 */
public class LeetCode2399 {
    public boolean checkDistances(String s, int[] distance) {
        char[] array = s.toCharArray();
        Map<Character, int[]> charMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (charMap.containsKey(array[i])) {
                charMap.get(array[i])[1] = i;
            } else {
                int[] index = new int[]{i, 0};
                charMap.put(array[i], index);
            }
        }
        for (int i = 0; i < distance.length; i++) {
            char c = (char) ('a' + i);
            if (!charMap.containsKey(c)) {
                continue;
            }
            int[] index = charMap.get(c);
            if (index[1] - index[0] != distance[i] + 1) {
                return false;
            }
        }
        return true;
    }
}
