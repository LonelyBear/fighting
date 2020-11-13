package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/26 17:09
 * @description https://leetcode-cn.com/problems/add-two-numbers/
 */

public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode itr = first;
        boolean up = false;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (up) {
                sum += 1;
            }
            up = false;
            if (sum >= 10) {
                up = true;
                sum = sum % 10;
            }
            ListNode temp = new ListNode(sum);
            itr.next = temp;
            itr = temp;
        }
        if (up) {
            ListNode temp = new ListNode(1);
            itr.next = temp;
        }
        return first.next;
    }
}
