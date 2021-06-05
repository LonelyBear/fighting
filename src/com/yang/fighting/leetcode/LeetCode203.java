package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/5 11:42
 * @description https://leetcode-cn.com/problems/remove-linked-list-elements/ 203. 移除链表元素
 */

public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode first = new ListNode(0, head);
        ListNode pre = first;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head = head.next;
            } else {
                head = head.next;
                pre = pre.next;
            }
        }
        return first.next;
    }
}
