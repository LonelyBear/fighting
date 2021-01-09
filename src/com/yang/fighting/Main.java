package com.yang.fighting;


import com.yang.fighting.base.ListNode;
import com.yang.fighting.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LeetCode86 l = new LeetCode86();
        // 1->4->3->2->5->2
        ListNode node = new ListNode(1,
                new ListNode(4,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(2, null))))));
        l.partition(node, 3);
    }
}
