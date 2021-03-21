package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/21 10:21
 * @description https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 150. 逆波兰表达式求值
 */

public class LeetCode150    {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (stack.isEmpty()) {
                stack.push(Integer.valueOf(s));
                continue;
            }
            if ("+".equals(s) || "-".equals(s) || "/".equals(s) || "*".equals(s)) {
                // 遇到运算符计算
                int second = stack.pop();
                int first = stack.pop();
                int tmp = 0;
                switch (s) {
                    case "+":
                        tmp = first + second;
                        break;
                    case "-":
                        tmp = first - second;
                        break;
                    case "*":
                        tmp = first * second;
                        break;
                    case "/":
                        tmp = first / second;
                        break;
                    default:
                        break;
                }
                stack.push(tmp);
                continue;
            }
            stack.push(Integer.valueOf(s));
        }
        return stack.pop();
    }
}
