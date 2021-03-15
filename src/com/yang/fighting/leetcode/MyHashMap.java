package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/15 11:10
 * @description https://leetcode-cn.com/problems/design-hashmap/ 706. 设计哈希映射
 */

public class MyHashMap {

    private final boolean[] check;
    private final int[] data;

    /** Initialize your data structure here. */
    public MyHashMap() {
        check = new boolean[1000001];
        data = new int[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        check[key] = true;
        data[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (check[key]) {
            return data[key];
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        check[key] = false;
    }
}
