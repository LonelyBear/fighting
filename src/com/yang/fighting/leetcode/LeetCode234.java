package com.yang.fighting.leetcode;

import com.yang.fighting.base.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/16 22:38
 * @description https://leetcode.cn/problems/palindrome-linked-list/?favorite=2cktkvj 234. 回文链表
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            if (!Objects.equals(list.get(left), list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
