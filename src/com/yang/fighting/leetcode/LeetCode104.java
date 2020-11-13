package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/31 14:07
 * @description https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */

public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root);
    }

    private int process(TreeNode node) {
        if (node.right == null && node.left == null) {
            return 1;
        }
        if (node.left == null) {
            return process(node.right) + 1;
        }
        if (node.right == null) {
            return process(node.left) + 1;
        }
        return Math.max(process(node.right) + 1, process(node.left) + 1);
    }
}
