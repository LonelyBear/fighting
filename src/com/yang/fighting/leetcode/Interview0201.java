package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yang tao
 * @version 1.0
 * @date 2020/10/27 17:02
 * @description https://leetcode-cn.com/problems/remove-duplicate-node-lcci/submissions/
 */

public class Interview0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = new ListNode(0);
        ListNode pre = first;
        Set<Integer> tmp = new HashSet<>();
        while (head != null) {
            if (!tmp.contains(new Integer(head.val))) {
                tmp.add(new Integer(head.val));
                pre.next = head;
                pre = pre.next;
            } else {
                pre.next = head.next;
            }
            head = head.next;
        }
        return first.next;
    }
}
