package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/5/29 19:54
 * @description https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */

public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> r1 = getList(l1);
        List<Integer> r2 = getList(l2);
        r1.addAll(r2);
        r1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return getListNode(r1);
    }

    private List<Integer> getList(ListNode l1) {
        if (l1 == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        ListNode node = l1;
        while (true) {
            list.add(node.val);
            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        return list;
    }

    public ListNode getListNode(List<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        ListNode first = new ListNode(0);
        ListNode itr = new ListNode(0);
        for (int i = 0; i < list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            if (i == 0) {
                first.next = node;
            }
            itr.next = node;
            itr = node;
        }
        return first.next;
    }
}
