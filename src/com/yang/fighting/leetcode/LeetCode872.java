package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/10 12:07
 * @description
 */

public class LeetCode872 {

    List<Integer> list1;
    List<Integer> list2;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        getList(root1, 1);
        getList(root2, 2);
        System.out.println(list1);
        System.out.println(list2);
        return compareList(list1, list2);
    }


    private void getList(TreeNode node, int i) {
        if (node.right == null && node.left == null) {
            if (i == 1) {
                list1.add(node.val);
            } else {
                list2.add(node.val);
            }
        }
        if (node.left != null) {
            getList(node.left, i);
        }
        if (node.right != null) {
            getList(node.right, i);
        }
    }

    private boolean compareList(List<Integer> list1, List<Integer> list2) {
        if (list1.size() == 0 || list2.size() == 0) {
            return false;
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(i);
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
