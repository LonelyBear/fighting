package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/29 19:39
 * @description https://leetcode.cn/problems/merge-two-binary-trees/?favorite=2cktkvj 617. 合并二叉树
 */
public class LeetCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return root2;
        }
        recur(root1, root2);
        return root1;
    }

    private void recur(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.val = node1.val + node2.val;
        if (node2.left != null) {
            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                recur(node1.left, node2.left);
            }
        }
        if (node2.right != null) {
            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                recur(node1.right, node2.right);
            }
        }
    }

}
