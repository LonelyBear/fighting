package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/15 15:33
 * @description https://leetcode.cn/problems/binary-tree-inorder-traversal/?favorite=2cktkvj 94. 二叉树的中序遍历
 */
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        process(result, root);
        return result;
    }

    private void process(List<Integer> result, TreeNode node) {
        if (node.left != null) {
            process(result, node.left);
        }
        result.add(node.val);
        if (node.right != null) {
            process(result, node.right);
        }
    }

}
