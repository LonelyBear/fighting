package com.yang.fighting.leetcode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/5 22:42
 * @description
 */

public class LRUCacheV2 {

    private ConcurrentHashMap<Integer, Node> cache = new ConcurrentHashMap<>();
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        // 头尾相连
        head.next = tail;
        tail.pre = head;
    }

    private static class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;
    }

    // 插入节点到队列头部
    private void addNodeToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    // 删除节点
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    //  删除节点 by LRU
    private void removeNodeByLRU() {
        removeNode(tail.pre);
    }

    // 移动节点到头部
    private void removeNodeToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }


    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNodeToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = val;
            removeNodeToHead(node);
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = val;
            cache.put(key, newNode);
            addNodeToHead(newNode);
            if (cache.size() > capacity) {
                cache.remove(tail.pre.key);
                removeNodeByLRU();
            }
        }
    }

}
