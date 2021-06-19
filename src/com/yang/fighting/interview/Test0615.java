package com.yang.fighting.interview;

import com.yang.fighting.base.ListNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/15 20:44
 * @description
 */

public class Test0615 {

    public ListNode mergeList(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        // sorted
        if (node1.val < node2.val) {
            node1.next = mergeList(node1.next, node2);
            return node1;
        }else {
            node2.next = mergeList(node1, node2.next);
            return node2;
        }
    }
}
