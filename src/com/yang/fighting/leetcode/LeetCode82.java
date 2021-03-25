package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/25 10:07
 * @description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/ 82. 删除排序链表中的重复元素 II
 */

public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> needDelSet = new HashSet<>();
        if (head == null) {
            return null;
        }

        ListNode start = new ListNode(0, head);
        ListNode pre_start = new ListNode(0, start);
        ListNode one = pre_start;
        ListNode pre = start;
        while (head != null) {
            // check if del
            if (needDelSet.contains(head.val)) {
                one.next = head.next;
                head = head.next;
            } else if (numSet.contains(head.val)) {
                // 如果走到这个分支说明需要删除前面一个节点和当前节点
                needDelSet.add(head.val);
                one.next = head.next;
                pre = one;
                head = head.next;
            } else {
                // 正常遍历
                numSet.add(head.val);
                one = pre;
                pre = head;
                head = head.next;
            }
        }
        return start.next;
    }
}
