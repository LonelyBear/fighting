package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/5/30 21:56
 * @description https://leetcode.cn/problems/delete-nodes-and-return-forest/
 */
public class LeetCode1110 {

    List<TreeNode> result;
    Set<Integer> deleteNumSet;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<>();
        deleteNumSet = new HashSet<>();
        for (int n : to_delete) {
            deleteNumSet.add(n);
        }
        if (root == null) {
            return result;
        }
        if (deleteNumSet.contains(root.val)) {
            process(root.left, null);
            root.left = null;
            process(root.right, null);
            root.right = null;
        } else {
            result.add(root);
            process(root.left, root);
            process(root.right, root);
        }
        return result;
    }

    private void process(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (!deleteNumSet.contains(node.val)) {
            if (parent == null) {
                result.add(node);
            }
            process(node.left, node);
            process(node.right, node);
        } else {
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            process(node.left, null);
            node.left = null;
            process(node.right, null);
            node.right = null;
        }
    }
}
