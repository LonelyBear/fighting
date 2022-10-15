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
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }




}
