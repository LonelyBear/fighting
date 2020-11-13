package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/29 10:46
 * @description https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 */

public class LeetCode129 {

    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }


        process(root, root.val);
        return res;
    }

    private void process(TreeNode node, int num) {

        if (node.left != null) {
            process(node.left, num * 10 + node.left.val);
        }
        if (node.right != null) {
            process(node.right, num * 10 + node.right.val);
        }
        if (node.right == null && node.left == null) {
            res = res + num;
        }
    }
}
