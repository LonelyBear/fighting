package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/13 09:55
 * @description https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 783. 二叉搜索树节点最小距离
 */

public class LeetCode783 {

    List<Integer> list;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            // 不会出现
            return 0;
        }
        list = new ArrayList<>();
        process(root);
        Collections.sort(list);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, Math.abs(list.get(i) - list.get(i - 1)));
        }
        return res;
    }

    private void process(TreeNode node) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        if (node.left == null) {
            list.add(node.val);
            process(node.right);
            return;
        }
        if (node.right == null) {
            list.add(node.val);
            process(node.left);
            return;
        }
        list.add(node.val);
        process(node.left);
        process(node.right);
    }

}
