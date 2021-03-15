package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/12 12:01
 * @description https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 剑指 Offer 24. 反转链表
 */

public class SwordOffer24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            // 先赋值
            next = cur.next;
            // 把当前节点的next志向前一个节点
            cur.next = start.next;
            // 头节点链接当前节点, 保证是最新的，这样下面一个节点可以直接串在它上面
            start.next = cur;
            cur = next;

        }
        return start.next;
    }
}
