package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/10 22:15
 * @description https://leetcode.cn/problems/next-greater-node-in-linked-list/ 1019. 链表中的下一个更大节点
 */
public class LeetCode1019 {
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int[] ans = new int[list.size()];
        stack.add(0);
        for (int i = 1; i < list.size(); i++) {
            int cur = list.get(i);
            while (!stack.isEmpty() && list.get(stack.peek()) < cur) {
                ans[stack.poll()] = cur;
            }
            stack.push(i);
        }
        return ans;
    }
}
