package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/12/3 21:51
 * @description https://leetcode.cn/problems/second-largest-digit-in-a-string/ 1796. 字符串中第二大的数字
 */
public class LeetCode1796 {
    public int secondHighest(String s) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                set.add(s.charAt(i) - '0');
            }
        }
        if (set.size() < 2) {
            return -1;
        }
        return set.stream().sorted((o1, o2) -> Integer.compare(o2, o1))
                .collect(Collectors.toList())
                .get(1);
    }
}
