package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/16 22:02
 * @description https://leetcode.cn/problems/reverse-linked-list/?favorite=2cktkvj 206. 反转链表
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode first = new ListNode();
        while (head != null) {
            ListNode tmp = head.next;
            head.next = first.next;
            first.next = head;
            head = tmp;
        }
        return first.next;
    }
}
