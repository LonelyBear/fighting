package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/31 10:29
 * @description https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 */

public class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> indexMap;
    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> indexSet = indexMap.getOrDefault(val, new HashSet<>());
        indexSet.add(list.size() - 1);
        indexMap.put(val, indexSet);
        return indexSet.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        }
        Iterator<Integer> iterator = indexMap.get(val).iterator();
        int removeIndex = iterator.next();
        int lastNum = list.get(list.size() - 1);
        list.set(removeIndex, lastNum);
        indexMap.get(val).remove(removeIndex);
        indexMap.get(lastNum).remove(list.size() - 1);
        if (removeIndex != list.size() - 1) {
            indexMap.get(lastNum).add(removeIndex);
        }
        if (indexMap.get(val).size() == 0) {
            indexMap.remove(val);
        }
        list.remove(list.size() - 1);
        return false;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}
