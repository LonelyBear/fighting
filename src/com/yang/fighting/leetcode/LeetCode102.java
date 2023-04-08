package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/8 19:23
 * @description https://leetcode.cn/problems/binary-tree-level-order-traversal/?favorite=2cktkvj 102. 二叉树的层序遍历
 */
public class LeetCode102 {

    private List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int level) {
        add(level, node.val);
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            dfs(node.left, level + 1);
        }
        if (node.right != null) {
            dfs(node.right, level + 1);
        }

    }


    private void add(int level, int val) {
        if (result.size() <= level) {
            result.add(level, new ArrayList<>());
        }
        result.get(level).add(val);
    }
}
