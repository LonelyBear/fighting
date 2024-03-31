package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/11/7 23:28
 * @description
 */
public class LeetCode102V2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, root, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (ans.size() < level + 1) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        dfs(ans, node.left, level + 1);
        dfs(ans, node.right, level + 1);
    }
}
