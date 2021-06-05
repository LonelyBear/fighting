package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/4 10:27
 * @description https://leetcode-cn.com/problems/path-sum-ii/ 113. 路径总和 II
 */

public class LeetCode113 {
    List<List<Integer>> res;
    List<Integer> stack;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>(2);
        }
        res = new ArrayList<>();
        stack = new ArrayList<>();
        dfs(root, 0, sum);
        return res;
    }

    private void dfs(TreeNode node, int num, int sum) {
        if (node == null) {
            return;
        }
        num += node.val;
        stack.add(node.val);
        if (node.left == null && node.right == null && sum ==  num) {
            res.add(new ArrayList<>(stack));
        }
        dfs(node.left, num, sum);
        dfs(node.right, num, sum);
        stack.remove(stack.size() - 1);
    }
}
