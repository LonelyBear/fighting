package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/28 21:24
 * @description https://leetcode.cn/problems/merge-similar-items/ 2363. 合并相似的物品
 */
public class LeetCode2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }
        for (int[] item : items2) {
            map.merge(item[0], item[1], Integer::sum);
        }
        return map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(this::toList)
                .collect(Collectors.toList());
    }

    private List<Integer> toList(Map.Entry<Integer, Integer> entry) {
        List<Integer> list = new ArrayList<>();
        list.add(entry.getKey());
        list.add(entry.getValue());
        return list;
    }
}
