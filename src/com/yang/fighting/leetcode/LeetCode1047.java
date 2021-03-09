package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/9 14:05
 * @description https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/ 1047. 删除字符串中的所有相邻重复项
 */

public class LeetCode1047 {

    public String removeDuplicates(String S) {
        if (S.length() < 2) {
            return S;
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (deque.isEmpty()) {
                deque.addLast(S.charAt(i));
                continue;
            }
            if (deque.peekLast().equals(S.charAt(i))) {
                deque.pollLast();
            } else {
                deque.addLast(S.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.pollFirst());
        }
        return builder.toString();
    }

}
