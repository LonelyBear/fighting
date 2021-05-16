package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/16 09:54
 * @description https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/ 421. 数组中两个数的最大异或值
 */

/**
 * 通过构造二叉前缀树来缩短查询时间 时间复杂度为 O(nlogC) C为树的层数
 */
public class LeetCode421 {

        Trie root = new Trie();
        static final int HIGH_BIT = 30;

        public int findMaximumXOR(int[] nums) {
            int len = nums.length;
            int res = 0;
            for (int i = 1; i < len; i++) {
                addToTrie(nums[i - 1]);
                res = Math.max(res, findMaxNor(nums[i]));
            }
            return res;
        }

        private void addToTrie(int num) {
            Trie cur = root;
            for (int i = HIGH_BIT; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0) {
                    if (cur.left == null) {
                        cur.left = new Trie();
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = new Trie();
                    }
                    cur = cur.right;
                }
            }
        }

        public int findMaxNor(int num) {
            Trie cur = root;
            int x = 0;
            for (int i = HIGH_BIT; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0) {
                    // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
                    if (cur.right != null) {
                        cur = cur.right;
                        x = x * 2 + 1;
                    } else {
                        cur = cur.left;
                        x = x * 2;
                    }
                } else {
                    // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                    if (cur.left != null) {
                        cur = cur.left;
                        x = x * 2 + 1;
                    } else {
                        cur = cur.right;
                        x = x * 2;
                    }
                }
            }
            return x;
        }

        // 字典树搜索
        // 数字转化成二进制
        public static class Trie {
            Trie left;
            Trie right;
        }
}
