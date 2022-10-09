package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/9 21:28
 * @description https://leetcode.cn/problems/score-of-parentheses/ 856. 括号的分数
 */
public class LeetCode856 {
    public int scoreOfParentheses(String s) {
        // 栈的使用
        // from 宫水三叶的解法
        // 非常巧妙 遇到 ( 置 0 , 遇 ) 进行判断 如果 0 0 则为1 如果 不为0 则 2 * m
        // 依次进行遍及判断
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int tmp = stack.pop();
                stack.push(stack.pop() + Math.max(tmp * 2, 1));
            }
        }
        return stack.pop();
    }
}
