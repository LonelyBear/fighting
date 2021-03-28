package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/28 09:59
 * @description https://leetcode-cn.com/problems/binary-search-tree-iterator/ 173. 二叉搜索树迭代器
 */

public class BSTIterator {

    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        stack.push(root);
    }

    public int next() {
        while (stack.peek() != null) {
            TreeNode node;
            if (stack.peek().left != null) {
                node  = stack.peek();
                stack.push(node.left);
                node.left = null;
            } else if (stack.peek().right != null) {
                node = stack.pop();
                stack.push(node.right);
                return node.val;
            } else {
                return stack.pop().val;
            }
        }
        return 0;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

