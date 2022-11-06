package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/6 14:01
 * @description https://leetcode.cn/problems/goal-parser-interpretation/ 1678. 设计 Goal 解析器
 */
public class LeetCode1678 {
    public String interpret(String command) {
        if (command.length() == 0) {
            return "";
        }
        Deque<Character> eleStack = new ArrayDeque<>();
        Deque<Character> opStack = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        for (char c : command.toCharArray()) {
            if (c == '(') {
                opStack.addLast(c);
            } else if (c != ')') {
                if (!opStack.isEmpty() && opStack.peekLast() == '(') {
                    eleStack.addLast(c);
                } else {
                    builder.append(c);
                }
            } else {
                if (eleStack.isEmpty()) {
                    builder.append('o');
                }
                while (!eleStack.isEmpty()) {
                    builder.append(eleStack.pollFirst());
                }
                opStack.pollLast();
            }
        }
        return builder.toString();
    }
}
