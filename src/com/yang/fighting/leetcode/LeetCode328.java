package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/13 10:11
 * @description
 */

public class LeetCode328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // 记录第二个node
        ListNode second = head.next;
        ListNode secondFirst = head.next;
        ListNode headFirst = head;
        while (second != null && head != null) {
            if (head.next != null) {
                System.out.println(head);
                head.next = head.next.next;
                head = head.next;
            }
            if(second.next != null) {
                System.out.println(second);
                second.next = second.next.next;
                second = second.next;
            }
        }
        // 连起来
        ListNode node = headFirst;
        while (true) {
            if (node.next == null) {
                node.next = secondFirst;
                break;
            } else {
                node = node.next;
            }
        }
        return headFirst;
    }
}
