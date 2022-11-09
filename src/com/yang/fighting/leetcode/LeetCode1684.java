package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/8 13:04
 * @description https://leetcode.cn/problems/count-the-number-of-consistent-strings/ 1684. 统计一致字符串的数目
 */
public class LeetCode1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        int result = 0;
        for (String word : words) {
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result++;
            }
        }
        return result;
    }
}
