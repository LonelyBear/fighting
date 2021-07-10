package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/10 19:58
 * @description https://leetcode-cn.com/problems/time-based-key-value-store/ 981. 基于时间的键值存储
 */

public class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> data;

    /** Initialize your data structure here. */
    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        data.computeIfAbsent(key, k -> new TreeMap<>());
        data.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = data.get(key);
        if (treeMap == null) return "";
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        if (entry == null) return "";
        return entry.getValue();
    }
}
