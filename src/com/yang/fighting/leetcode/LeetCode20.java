package com.yang.fighting.leetcode;

import java.util.Stack;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/30 14:38
 * @description https://leetcode-cn.com/problems/valid-parentheses/
 */

public class LeetCode20 {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                Character character = stack.peek();
                switch (s.charAt(i)) {
                    case '{':
                    case '[':
                    case '(':
                        stack.push(s.charAt(i));
                        break;
                    case '}':
                        if (character == '{') {
                            stack.pop();
                        } else {
                            stack.push(s.charAt(i));
                        }
                        break;
                    case ')':
                        if (character == '(') {
                            stack.pop();
                        } else {
                            stack.push(s.charAt(i));
                        }
                        break;
                    case ']':
                        if (character == '[') {
                            stack.pop();
                        } else {
                            stack.push(s.charAt(i));
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.empty();
    }
}
