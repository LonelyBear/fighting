package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/20 17:45
 * @description https://leetcode-cn.com/problems/throne-inheritance/ 1600. 皇位继承顺序
 */

public class ThroneInheritance {

    private final Node root;
    private final Map<String, int[]> indexMap;

    public ThroneInheritance(String kingName) {
        root = new Node();
        root.children = new ArrayList<>();
        root.children.add(new Node(kingName));
        indexMap = new HashMap<>();
        indexMap.put(kingName, new int[]{0});
    }

    public void birth(String parentName, String childName) {
        int[] index = indexMap.get(parentName);
        int[] childIndex = new int[index.length + 1];
        Node node = root;
        // 通过index数组找到parent
        for (int i = 0; i < index.length; i++) {
            node = node.children.get(index[i]);
            childIndex[i] = index[i];
        }
        if (node.children == null) {
            node.children = new ArrayList<>();
        }
        node.children.add(new Node(childName));
        childIndex[index.length] = node.children.size() - 1;
        indexMap.put(childName, childIndex);
    }

    public void death(String name) {
        int[] index = indexMap.get(name);
        Node node = root;
        for (int pos : index) {
            node = node.children.get(pos);
        }
        node.death();
    }

    public List<String> getInheritanceOrder() {
        List<Node> nodes = new ArrayList<>();
        dfs(nodes, root.children.get(0));
        return nodes.stream().filter(Node::getAlive).map(Node::getName).collect(Collectors.toList());
    }

    private void dfs(List<Node> list, Node node) {
        if (node == null) {
            return;
        }
        list.add(node);
        if (node.children != null) {
            for (Node n : node.children) {
                dfs(list, n);
            }
        }

    }

    private static class Node {
        public String name;
        public Boolean alive;
        public List<Node> children;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getAlive() {
            return alive;
        }

        public void setAlive(Boolean alive) {
            this.alive = alive;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public Node() {
        }

        public Node(String name, Boolean alive, List<Node> children) {
            this.name = name;
            this.alive = alive;
            this.children = children;
        }

        public Node(String name) {
            this.name = name;
            this.alive = true;
            this.children = null;
        }

        public void death() {
            this.alive = false;
        }
    }
}
