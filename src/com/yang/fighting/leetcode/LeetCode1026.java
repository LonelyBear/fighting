package com.yang.fighting.leetcode;

import com.yang.fighting.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/18 22:04
 * @description https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/ 1026. 节点与其祖先之间的最大差值
 */
public class LeetCode1026 {

    private List<Integer> list;
    private int ans;

    public int maxAncestorDiff(TreeNode root) {
        list = new ArrayList<>();
        ans = 0;
        process(root);
        return ans;
    }

    private void process(TreeNode node) {
        if (node == null) {
            return;
        }
        if (list.size() != 0) {
            List<Integer> tmpList = new ArrayList<>(list);
            Collections.sort(tmpList);
            ans = Math.max(ans, Math.abs(tmpList.get(0) - node.val));
            ans = Math.max(ans, Math.abs(tmpList.get(tmpList.size() - 1) - node.val));
        }
        list.add(node.val);
        process(node.left);
        process(node.right);
        list.remove(list.size() - 1);
    }

}
