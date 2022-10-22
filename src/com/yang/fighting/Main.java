package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode543 proxy = new LeetCode543();
        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode node1 = new TreeNode();
        node1.val = 2;
        root.left = node1;
        proxy.diameterOfBinaryTree(root);
    }

}
