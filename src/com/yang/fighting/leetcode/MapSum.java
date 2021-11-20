package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/11/14 22:46
 * @description https://leetcode-cn.com/problems/map-sum-pairs/ 677. 键值映射
 */
public class MapSum {

    private final Map<String, Integer> dataMap;
    private final Map<String, Integer> prefixMap;

    public MapSum() {
        dataMap = new HashMap<>();
        prefixMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        int diff = val - dataMap.getOrDefault(key, 0);
        dataMap.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            String prefix = key.substring(0, i);
            prefixMap.merge(prefix, diff, Integer::sum);
        }
    }

    public int sum(String prefix) {
        return prefixMap.getOrDefault(prefix, 0);
    }
}
