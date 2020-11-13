package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/6 11:20
 * @description https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 */

public class LeetCode1356 {
    public int[] sortByBits(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        Set<Integer> indexSet = new TreeSet<>();
        Map<Integer, List<Integer>> numMap = new HashMap<>();
        for (int j : arr) {
            int count = getOneCount(j);
            indexSet.add(count);
            List<Integer> list = numMap.getOrDefault(count, new ArrayList<>());
            list.add(j);
            numMap.put(count, list);
        }
        int[] res = new int[arr.length];
        int k = 0;
        for (int index : indexSet) {
            List<Integer> list = numMap.get(index);
            Collections.sort(list);
            for (Integer integer : list) {
                res[k] = integer;
                k++;
            }
        }
        return res;
    }

    private int getOneCount(int num) {
        if (num == 0) {
            return 0;
        }
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}
