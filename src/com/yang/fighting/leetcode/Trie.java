package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/14 10:57
 * @description https://leetcode-cn.com/problems/implement-trie-prefix-tree/ 208. 实现 Trie (前缀树)
 */

public class Trie {
    
    private final TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }
        char[] array = word.toCharArray();
        TrieNode node = root;
        for (char c : array) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
            node.prefix++;
        }
        node.count++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length() == 0) {
            return false;
        }
        char[] array = word.toCharArray();
        TrieNode node = root;
        for (char c : array) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        if (node.count == 0) {
            return false;
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return false;
        }
        char[] array = prefix.toCharArray();
        TrieNode node = root;
        for (char c : array) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return false;
            }
            node = node.next[index];
        }
        return true;
    }

    public static class TrieNode {
        private int count;
        private int prefix;
        private TrieNode[] next;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPrefix() {
            return prefix;
        }

        public void setPrefix(int prefix) {
            this.prefix = prefix;
        }

        public TrieNode[] getNext() {
            return next;
        }

        public void setNext(TrieNode[] next) {
            this.next = next;
        }

        public TrieNode() {
            count = 0;
            prefix = 0;
            // 初始化长度为26的数组, 因为都是小写字母
            next = new TrieNode[26];
        }

    }
}
