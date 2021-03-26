package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/26 09:42
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/ 83. 删除排序链表中的重复元素
 */

public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode start = new ListNode(Integer.MAX_VALUE, head);
        ListNode pre = start;
        while (head != null) {
            // 判断是否与前一个元素一致, 如果一致则删除
            if (head.val == pre.val) {
                pre.next = head.next;
            } else {
                // 如果不相等则继续迭代
                pre = head;
            }
            head = head.next;
        }
        return start.next;
    }
}
