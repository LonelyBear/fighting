package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/18 14:51
 * @description https://leetcode-cn.com/problems/reverse-linked-list-ii/ 92. 反转链表 II
 */

public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = new ListNode(0, head);
        int curIndex = 1;
        // 先遍历到left
        ListNode stage1 = start;
        while (head != null && curIndex < left) {
            stage1 = head;
            head = head.next;
            curIndex++;
        }
        // 反转链表
        ListNode pre = new ListNode(0);
        ListNode tmp;
        ListNode stage2 = head;
        while (head != null && curIndex <= right) {
            tmp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = tmp;
            curIndex++;
        }
        stage1.next = pre.next;
        stage2.next = head;
        return start.next;
    }
}
