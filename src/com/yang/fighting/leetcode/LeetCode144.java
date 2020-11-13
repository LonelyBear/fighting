package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/27 10:16
 * @description https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */

public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        process(res, root);
        return res;
    }

    private void process(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        process(list, node.left);
        process(list, node.right);
    }

}
