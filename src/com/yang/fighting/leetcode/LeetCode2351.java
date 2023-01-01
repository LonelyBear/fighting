package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/1/1 19:42
 * @description https://leetcode.cn/problems/first-letter-to-appear-twice/ 2351. 第一个出现两次的字母
 */
public class LeetCode2351 {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return c;
            }
            set.add(c);
        }
        return '#';
    }
}
