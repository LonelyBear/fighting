package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/10/16 21:46
 * @description
 */
public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.merge(num, 1, Integer::sum);
        }
        List<Integer> res = new ArrayList<>(2);
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        return new int[]{res.get(0), res.get(1)};
    }
}
