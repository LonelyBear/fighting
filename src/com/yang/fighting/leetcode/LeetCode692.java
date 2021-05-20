package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/20 07:58
 * @description https://leetcode-cn.com/problems/top-k-frequent-words/ 692. 前K个高频单词
 */

public class LeetCode692 {
    public List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0) {
            return Collections.emptyList();
        }
        Map<String, Integer> cntMap = new HashMap<>();
        for (String s : words) {
            cntMap.merge(s, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
                // return Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
