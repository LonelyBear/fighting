package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/18 14:50
 * @description https://leetcode-cn.com/problems/lru-cache/
 */

import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;

    private Integer capacity;

    // ReentrantLock lock = new ReentrantLock();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {

        map.put(key, value);
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

}
