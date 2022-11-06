package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/1 22:54
 * @description https://leetcode.cn/problems/generate-parentheses/?favorite=2cktkvj 22. 括号生成
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        dfs(result, list, 0, n);
        return result.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(List<String> result, List<Character> list, int index, int n) {
        if (index == n * 2) {
            if (check(list)) {
                result.add(toString(list));
            }
            return;
        }
        list.add('(');
        dfs(result, list, index + 1, n);
        list.remove(list.size() - 1);
        list.add(')');
        dfs(result, list, index + 1, n);
        list.remove(list.size() - 1);
    }

    private boolean check(List<Character> list) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : list) {
            if (c == '(') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty() || stack.peekLast() == ')') {
                    return false;
                }
                stack.pollLast();
            }
        }
        return stack.isEmpty();
    }

    private String toString(List<Character> list) {
        StringBuilder builder = new StringBuilder();
        list.forEach(builder::append);
        return builder.toString();
    }
}
