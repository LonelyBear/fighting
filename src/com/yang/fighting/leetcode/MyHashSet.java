package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/15 10:54
 * @description https://leetcode-cn.com/problems/design-hashset/ 705. 设计哈希集合
 */

class MyHashSet {

    private final boolean[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new boolean[1000001];
    }

    public void add(int key) {
        if (!data[key]) {
            data[key] = true;
        }
    }

    public void remove(int key) {
        if (data[key]) {
            data[key] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return data[key];
    }
}
