package com.yang.fighting.leetcode;

import com.yang.fighting.base.Node;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/11/21 11:12
 * @description https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/ 559. N 叉树的最大深度
 */
public class LeetCode559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.size() == 0) {
            return 1;
        }
        int res = 0;
        for (Node node : root.children) {
            res = Math.max(maxDepth(node) + 1, res);
        }
        return res;
    }
}
