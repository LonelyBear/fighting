package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/22 20:42
 * @description https://leetcode.cn/problems/diameter-of-binary-tree/?favorite=2cktkvj 543. 二叉树的直径
 */
public class LeetCode543 {

    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        calc(root);
        return ans;
    }

    private int calc(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = calc(node.left);
        int rightDepth = calc(node.right);
        ans = Math.max(ans, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
