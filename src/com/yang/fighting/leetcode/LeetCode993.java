package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/17 11:50
 * @description https://leetcode-cn.com/problems/cousins-in-binary-tree/ 993. 二叉树的堂兄弟节点
 */

public class LeetCode993 {

    private int x, y, xDepth, yDepth;
    private boolean xFound = false, yFound = false;
    private TreeNode xParent, yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        dfs(root, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xFound = true;
            xDepth = depth;
            xParent = parent;
        } else if (node.val == y) {
            yFound = true;
            yDepth = depth;
            yParent = parent;
        }
        if (xFound && yFound) {
            return;
        }
        dfs(node.left, depth + 1, node);
        if (xFound && yFound) {
            return;
        }
        dfs(node.right, depth + 1, node);
    }
}
