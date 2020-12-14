package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/14 21:17
 * @description https://leetcode-cn.com/problems/group-anagrams/
 */

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            List<String> stringList;
            if (map.containsKey(String.valueOf(chars))) {
                stringList = map.get(String.valueOf(chars));
            } else {
                stringList = new ArrayList<>();
            }
            stringList.add(str);
            map.put(String.valueOf(chars), stringList);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
