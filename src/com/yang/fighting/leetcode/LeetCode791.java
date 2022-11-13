package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/13 19:32
 * @description https://leetcode.cn/problems/custom-sort-string/ 791. 自定义字符串排序
 */
public class LeetCode791 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < order.toCharArray().length; i++) {
            rankMap.put(order.toCharArray()[i], i);
        }
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        list.sort((o1, o2) -> {
            Integer index1 = rankMap.get(o1);
            Integer index2 = rankMap.get(o2);
            if (index1 == null && index2 == null) {
                return o1 - o2;
            }
            if (index1 == null) {
                return 1;
            }
            if (index2 == null) {
                return -1;
            }
            return Integer.compare(index1, index2);
        });
        StringBuilder builder = new StringBuilder();
        list.forEach(builder::append);
        return builder.toString();
    }
}
