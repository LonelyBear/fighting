package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/6/11 20:30
 * @description https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/ 1171. 从链表中删去总和值为零的连续节点
 */
public class LeetCode1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode tmp = node; tmp != null ; tmp = tmp.next) {
            sum = sum + tmp.val;
            map.put(sum, tmp);
        }
        sum = 0;
        for (ListNode tmp = node; tmp != null; tmp = tmp.next) {
            sum = sum + tmp.val;
            tmp.next = map.get(sum).next;
        }
        return node.next;
    }
}
