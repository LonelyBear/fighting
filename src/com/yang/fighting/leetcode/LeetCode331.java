package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/12 11:03
 * @description https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * 331. 验证二叉树的前序序列化
 */

public class LeetCode331 {
    public boolean isValidSerialization(String preorder) {
        int len = preorder.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        for (int i = 0; i < len; i++) {
            char c = preorder.charAt(i);
            if (stack.isEmpty()) {
                return false;
            }
            if (c == ',') {
                continue;
            }
            if (c == '#') {
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                continue;
            }
            while (i < len && preorder.charAt(i) != ',') {
                i++;
            }
            int top = stack.pop() - 1;
            if (top > 0) {
                stack.push(top);
            }
            stack.push(2);
        }
        return stack.isEmpty();
    }
}
