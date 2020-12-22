package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/22 19:13
 * @description https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */

public class LeetCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(2);
        }
        List<Deque<Integer>> res = new ArrayList<>();
        process(res, root, 0);
        return res.stream().map(Deque::peekLast).collect(Collectors.toList());
    }

    private void process(List<Deque<Integer>> res, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (res.size() <= level) {
            Deque<Integer> queue = new LinkedList<>();
            res.add(queue);
        }
        Deque<Integer> currentQueue = res.get(level);
        currentQueue.offer(node.val);
        process(res, node.left, level + 1);
        process(res, node.right, level + 1);
    }
}
