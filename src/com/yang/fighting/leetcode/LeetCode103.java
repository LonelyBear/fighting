package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/22 14:14
 * @description https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */

public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // dfs
        if (root == null) {
            return new ArrayList<>(2);
        }
        List<List<Integer>> res = new ArrayList<>();
        process(res, root, 0);
        return res;
    }

    private void process(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        // 如果res.size() <= level说明下一层的集合还没创建，所以要先创建下一层的集合
        if (res.size() < level) {
            List<Integer> newList = new LinkedList<>();
            res.add(newList);
        }
        // 遍历到第几层我们就操作第几层的数据
        List<Integer> list = res.get(level);
        if ((level % 2 == 0)) {
            list.add(node.val);
        } else {
            list.add(0, node.val);
        }
        process(res, node.left, level + 1);
        process(res, node.right, level + 1);
    }
}
