package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/20 16:52
 * @description https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        TreeMap<Integer, ListNode> treeMap = new TreeMap<>();
        treeMap.put(head.val, head);
        while (head.next != null) {
            ListNode nextNode = head.next;
            if (head.val > nextNode.val) {
                ListNode pre = treeMap.firstEntry().getValue();
                if (nextNode.val < pre.val) {
                    swapNode(first, nextNode, head);
                } else {
                    Iterator<Map.Entry<Integer, ListNode>> iterator = treeMap.entrySet().iterator();
                    iterator.next();
                    ListNode currentNode;
                    while (iterator.hasNext()) {
                        currentNode = iterator.next().getValue();
                        if (nextNode.val < currentNode.val) {
                            swapNode(pre, nextNode, head);
                            break;
                        }
                        pre = currentNode;
                    }
                }
            }
            treeMap.put(nextNode.val, nextNode);
            head = nextNode;
        }
        return first.next;
    }

    private void swapNode(ListNode left, ListNode right, ListNode rightPre) {
        System.out.println(" left var = " + left.val + " right var = " + right.val + " rightPre var = " + rightPre.val);
        ListNode tmp = left.next;
        left.next = right;
        rightPre.next = right.next;
        right.next = tmp;
    }
}
