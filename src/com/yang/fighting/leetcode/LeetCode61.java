package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/27 09:20
 * @description https://leetcode-cn.com/problems/rotate-list/ 61. 旋转链表
 */

public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k == 0) return head;
        ListNode start = new ListNode(0);
        ListNode fHead = head;
        List<ListNode> list = new ArrayList<>();
        int len = 0;
        while (head != null) {
            len++;
            list.add(head);
            head = head.next;
        }
        if (len == k || len == 1 || k % len == 0) {
            return fHead;
        } else if (len < k) {
            k = k % len;
        }
        list.get(list.size() - k - 1).next = null;
        start.next = list.get(list.size() - k);
        list.get(list.size() - 1).next = fHead;
        return start.next;
    }
}
