package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/4 23:22
 * @description https://leetcode-cn.com/problems/intersection-of-two-linked-lists/ 160. 相交链表
 */

public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
