package com.yang.fighting.base;

import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/11/21 11:12
 * @description
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
