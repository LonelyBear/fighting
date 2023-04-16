package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/10 23:03
 * @description https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?favorite=2cktkvj 105. 从前序与中序遍历序列构造二叉树
 */
public class LeetCode105 {

    private Map<Integer, Integer> inorderValIndexMap;
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        inorderValIndexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderValIndexMap.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, len - 1, 0, len - 1);
    }

    private TreeNode buildTree(int preorderIndexLeft,
                               int preorderIndexRight,
                               int inorderIndexLeft,
                               int inorderIndexRight) {
        if (preorderIndexLeft > preorderIndexRight) {
            return null;
        }
        int rootVal = preorder[preorderIndexLeft];
        int inorderRootIndex = inorderValIndexMap.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        int leftTreeNodeNum = inorderRootIndex - inorderIndexLeft;
        node.left = buildTree(preorderIndexLeft + 1,
                preorderIndexLeft + leftTreeNodeNum,
                inorderIndexLeft,
                inorderRootIndex - 1);
        node.right = buildTree(preorderIndexLeft + leftTreeNodeNum + 1,
                preorderIndexRight,
                inorderRootIndex + 1,
                inorderIndexRight);
        return node;

    }
}
