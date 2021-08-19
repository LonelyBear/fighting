package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/23 10:31
 * @description https://leetcode-cn.com/problems/copy-list-with-random-pointer/ 138. 复制带随机指针的链表
 */

public class LeetCode138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(10001);
        Node pre = newHead;
        Node oldNode = head;
        while (oldNode != null) {
            Node node = new Node(oldNode.val);
            map.put(oldNode, node);
            pre.next = node;
            pre = pre.next;
            oldNode = oldNode.next;
        }
        oldNode = head;
        pre = newHead.next;
        while (oldNode != null) {
            if (oldNode.random != null) {
                pre.random = map.get(oldNode.random);
            }
            oldNode = oldNode.next;
            pre = pre.next;
        }
        return newHead.next;
    }

    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
