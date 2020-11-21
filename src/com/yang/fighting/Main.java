package com.yang.fighting;

import com.yang.fighting.base.ListNode;
import com.yang.fighting.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        LeetCode147 l = new LeetCode147();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode node4 = new ListNode(4, node3);
        l.insertionSortList(node4);
    }
}
