package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/4 10:35
 * @description https://leetcode-cn.com/problems/path-sum/ 112. 路径总和
 */

public class LeetCode112 {

    // 可以用递归来做 判断左右子树的和为targetSum - node.val

    private boolean res = false;
    private List<Integer> stack;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        stack = new ArrayList<>();
        process(root, 0, targetSum);
        return res;
    }

    private void process(TreeNode node, int sum, int targetSum) {
        if (res) {
            return;
        }
        if (node == null) {
            return;
        }
        stack.add(node.val);
        sum += node.val;
        if (node.left == null && node.right == null && sum == targetSum) {
            res = true;
            return;
        }
        process(node.left, sum, targetSum);
        process(node.right, sum, targetSum);
        stack.remove(stack.size() - 1);
    }
}
