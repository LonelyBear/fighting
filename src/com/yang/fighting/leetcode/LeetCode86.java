package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/9 12:18
 * @description https://leetcode-cn.com/problems/partition-list/  86. 分隔链表
 */

public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        // 临时链表存储
        ListNode tmp = new ListNode(0);
        ListNode tmp_pre = tmp;
        ListNode start = new ListNode(0);
        ListNode pre = start;
        while (head != null) {
            if (head.val >= x) {
                tmp_pre.next = head;
                pre.next = head.next;
                tmp_pre = tmp_pre.next;
                tmp_pre.next = null;
                head = pre.next;
            } else {
                pre.next = head;
                pre = head;
                head = head.next;
            }
        }
        if (tmp.next != null) {
            pre.next = tmp.next;
        }
        return start.next;
    }
}
