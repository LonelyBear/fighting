package com.yang.fighting;


import com.yang.fighting.base.ListNode;
import com.yang.fighting.leetcode.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LeetCode61 l = new LeetCode61();
        ListNode node7 = new ListNode(5, null);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        l.rotateRight(node1, 10);
    }
}
