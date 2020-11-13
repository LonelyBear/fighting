package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/26 20:47
 * @description https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 1;
        char[] input = s.toCharArray();
        Set<Character> tmp = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            tmp.clear();
            tmp.add(new Character(input[i]));
            for (int j = i + 1; j < s.length(); j++) {
                if (!tmp.contains(new Character(input[j]))) {
                    tmp.add(new Character(input[j]));
                } else {
                    break;
                }
            }
            System.out.println(tmp);
            res = Math.max(tmp.size(), res);
        }
        return res;
    }
}
