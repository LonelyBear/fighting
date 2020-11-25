package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/24 11:35
 * @description https://leetcode-cn.com/problems/count-complete-tree-nodes/
 */

public class LeetCode222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calc(root);
    }

    // 计算每个子树的节点数
    // 如果左右子树高度相等,则返回 2^n - 1 的个数
    // 如果左右子树高度不相等,则返回 左子树的个数 + 右子树的个数 + 1
    private int calc(TreeNode node) {
        TreeNode left = node;
        TreeNode right = node;
        int leftH = 0, rightH = 0;
        while (left != null) {
            left = left.left;
            leftH++;
        }
        while (right != null) {
            right = right.right;
            rightH++;
        }
        if (rightH == leftH) {
            return (int)Math.pow(2, leftH) - 1;
        } else {
            return 1 + calc(node.left) + calc(node.right);
        }
    }
}
