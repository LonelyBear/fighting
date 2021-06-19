package com.yang.fighting.interview;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/18 19:40
 * @description
 */

public class Test0618 {

    private static List<List<Integer>> res;

    public static List<List<Integer>> solve(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(2);
        }
        res = new ArrayList<>();
        // dfs
        dfs(root, 0);
        return res;
    }

    private static void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
        return;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, node1, node2);
        TreeNode node6 = new TreeNode(6, node3, node4);
        TreeNode head =  new TreeNode(0, node5, node6);
        List<List<Integer>> res = solve(head);
        System.out.println(res);
    }
}
