package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/5 22:37
 * @description https://leetcode.cn/problems/parsing-a-boolean-expression/ 1106. 解析布尔表达式
 */
public class LeetCode1106 {
    /**
     * 两个栈处理 运算符 和  暂存数据
     * 模拟即可
     *
     * @param expression
     * @return
     */
    public boolean parseBoolExpr(String expression) {
        Deque<Character> numStack = new ArrayDeque<>(), opStack = new ArrayDeque<>();
        for (char c : expression.toCharArray()) {
            if (c == ',') {
                continue;
            }
            if (c == 'f' || c == 't') {
                numStack.addLast(c);
            }
            if (c == '&' || c == '|' || c == '!') {
                opStack.addLast(c);
            }
            if (c == '(') {
                numStack.addLast('#');
            }
            if (c == ')') {
                char op = opStack.pollLast();
                char res = '^';
                while (!numStack.isEmpty() && numStack.peekLast() != '#') {
                    char top = numStack.pollLast();
                    if (res == '^') {
                        res = top;
                    } else {
                        res = calc(top, res, op);
                    }
                }
                if (op == '!') {
                    res = (res == 't') ? 'f' : 't';
                }
                numStack.pollLast();
                numStack.addLast(res);
            }
        }
        return numStack.peekLast() == 't';
    }


    private char calc(char a, char b, char op) {
        boolean x = (a == 't'), y = (b == 't');
        boolean ans = (op == '|') ? x | y : x & y;
        return ans ? 't' : 'f';
    }

}
