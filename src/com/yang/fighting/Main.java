package com.yang.fighting;


import com.yang.fighting.base.ListNode;
import com.yang.fighting.leetcode.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LeetCode92 l = new LeetCode92();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        l.reverseBetween(node5, 1, 1);
    }
}
