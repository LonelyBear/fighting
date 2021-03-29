package com.yang.fighting;


import com.yang.fighting.base.ListNode;
import com.yang.fighting.base.TreeNode;
import com.yang.fighting.leetcode.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        TreeNode root = new TreeNode(7);
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(15);
//        TreeNode node3 = new TreeNode(9);
//        TreeNode node4 = new TreeNode(20);
//        root.left = node1;
//        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;
//        BSTIterator iterator = new BSTIterator(root);
//        System.out.println(iterator.next()); // 返回 3
//        System.out.println(iterator.next()); // 返回 7
//        System.out.println(iterator.hasNext()); // 返回 True
//        System.out.println(iterator.next()); // 返回 9
//        System.out.println(iterator.hasNext()); // 返回 True
//        System.out.println(iterator.next()); // 返回 15
//        System.out.println(iterator.hasNext()); // 返回 True
//        System.out.println(iterator.next()); // 返回 20
//        System.out.println(iterator.hasNext()); // 返回 False
        LeetCode190 l = new LeetCode190();
        System.out.println(l.reverseBits(2));
    }
}
