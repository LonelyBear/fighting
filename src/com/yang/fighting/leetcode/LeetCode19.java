package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/31 23:00
 * @description https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?favorite=2cktkvj 19. 删除链表的倒数第 N 个结点
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int len = list.size();
        if (len == 1) {
            return null;
        }
        if (n == 1) {
            list.get(len - 2).next = null;
        } else if (n == len) {
            head = list.get(1);
        } else {
            list.get(len - 1 - n).next = list.get(len - n + 1);
        }
        return head;
    }
}
