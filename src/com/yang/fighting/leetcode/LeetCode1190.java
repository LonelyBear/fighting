package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/26 21:43
 * @description https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/ 1190. 反转每对括号间的子串
 */

public class LeetCode1190 {
    public String reverseParentheses(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (')' == c) {
                sb.reverse();
                sb.insert(0, stack.pop()); // 插在第一位
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
