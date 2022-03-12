package com.yang.fighting.leetcode;

import com.yang.fighting.base.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/3/12 10:33
 * @description https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/ 590. N 叉树的后序遍历
 */
public class LeetCode590 {

    private List<Integer> data;

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>(2);
        }
        data = new ArrayList<>();
        process(root);
        return data;
    }

    private void process(Node node) {
        if (node.children == null || node.children.size() == 0) {
            data.add(node.val);
            return;
        }
        node.children.forEach(this::process);
        data.add(node.val);
    }
}
