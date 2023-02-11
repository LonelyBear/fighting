package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/1/30 21:32
 * @description https://leetcode.cn/problems/merge-in-between-linked-lists/ 1669. 合并两个链表
 */
public class LeetCode1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode first = new ListNode(0, list1);
        ListNode pre = first, node = first.next;
        while (index < a) {
           pre = pre.next;
           node = node.next;
           index++;
        }
        while (index <= b) {
            node = node.next;
            index++;
        }
        pre.next = list2;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = node;
        return first.next;
    }
}
