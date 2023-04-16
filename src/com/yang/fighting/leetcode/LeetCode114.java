package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/16 13:07
 * @description https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?favorite=2cktkvj 114. 二叉树展开为链表
 */
public class LeetCode114 {

    private List<TreeNode> list;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        list = new ArrayList<>();
        process(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    private void process(TreeNode node) {
        if (node != null) {
            list.add(node);
            process(node.left);
            process(node.right);
        }
    }

}
