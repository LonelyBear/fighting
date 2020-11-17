package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/15 10:41
 * @description https://leetcode-cn.com/problems/remove-k-digits/
 */

public class LeetCode402 {

    public String removeKdigits(String num, int k) {
        int length = num.length();
        if (length == k) {
            return "0";
        }

        Deque<Character> deque = new LinkedList<>();

        // 使用双端队列进行 元素的剔除操作
        for (int i = 0; i < length; i++) {
            char currentChar = num.charAt(i);
            while (deque.size() != 0 && k > 0 && deque.peekLast() > currentChar) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(currentChar);
        }
        // 去除剩余的机会次数
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        // 去除前导0
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();

    }
}
