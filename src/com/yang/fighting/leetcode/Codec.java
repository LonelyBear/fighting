package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/1 10:02
 * @description https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/ 297. 二叉树的序列化与反序列化
 */

public class Codec {

    private final static int NULL = -10000;
    private final static TreeNode EMPTY = new TreeNode(NULL);
    private final static String EMPTY_TREE = "";
    private final static String SPILT = "_";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return EMPTY_TREE;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node.val).append(SPILT);
            if (!EMPTY.equals(node)) {
                queue.offer(node.left != null ? node.left : EMPTY);
                queue.offer(node.right != null ? node.right : EMPTY);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (EMPTY_TREE.equals(data)) return null;
        String[] dataArray = data.split(SPILT);
        int len = dataArray.length;
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < len - 1; i += 2) {
            TreeNode node = queue.poll();
            int left = Integer.parseInt(dataArray[i]), right = Integer.parseInt(dataArray[i + 1]);
            if (left != NULL) {
                node.left = new TreeNode(left);
                queue.offer(node.left);
            }
            if (right != NULL) {
                node.right = new TreeNode(right);
                queue.offer(node.right);
            }
        }
        return root;
    }
}
