package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.Objects;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/16 22:26
 * @description https://leetcode.cn/problems/invert-binary-tree/?favorite=2cktkvj 226. 翻转二叉树
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        process(root);
        return root;
    }

    private void process(TreeNode node) {
        if (node.right == null && node.left == null) {
            return;
        }
        if (node.left != null) {
            process(node.left);
        }
        if (node.right != null) {
            process(node.right);
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
